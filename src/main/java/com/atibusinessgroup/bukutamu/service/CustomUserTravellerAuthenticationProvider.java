package com.atibusinessgroup.bukutamu.service;

import com.atibusinessgroup.bukutamu.errors.UnlockedException;
import com.atibusinessgroup.bukutamu.errors.UserLockedException;
import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.TravelAgentDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserTravellerAuthenticationProvider implements AuthenticationProvider {

    @Value("${app.backend.url}")
    private String url;

    @Autowired
    private TravelAgentService travelAgentService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String[] fullnameAndPolicyNumberAndPassportNumberAndRememberme = ((String)authentication.getPrincipal()).split(",");
        String fullname = "";
        String policyNumber = "";
        String passsportNumber = "";
        String rememberMe = "true";

        if (fullnameAndPolicyNumberAndPassportNumberAndRememberme == null || fullnameAndPolicyNumberAndPassportNumberAndRememberme.length != 3) {
            throw new UsernameNotFoundException("Username not found");
        }

        fullname = fullnameAndPolicyNumberAndPassportNumberAndRememberme[0];
        policyNumber = fullnameAndPolicyNumberAndPassportNumberAndRememberme[1];
        passsportNumber = fullnameAndPolicyNumberAndPassportNumberAndRememberme[2];

        System.out.println("Fullname : "+fullname);
        System.out.println("policyNumber : "+policyNumber);
        System.out.println("passsportNumber : "+passsportNumber);
        try {
            UserInfo userInfo = shouldAuthenticateAgainstThirdPartySystem(fullname, policyNumber, passsportNumber, Boolean.valueOf(rememberMe));
            if (userInfo != null) {
                // setup role disini
                List<GrantedAuthority> authorities = new ArrayList<>();
                for(String role : userInfo.getRole()) {
                    System.out.println("ROLE : "+role);
                    authorities.add(new SimpleGrantedAuthority(role));
                }
                return new UsernamePasswordAuthenticationToken(userInfo, "", authorities);
            } else {
                throw new BadCredentialsException("Bad credential");
            }
        }catch(Exception e){
            //System.out.println("MASUK SINI : "+e.getMessage());
            throw e;
        }
    }

    private UserInfo shouldAuthenticateAgainstThirdPartySystem(String fullname, String policyNumber, String passportNumber, boolean rememberMe) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            public boolean hasError(ClientHttpResponse response) throws IOException {
                HttpStatus statusCode = response.getStatusCode();
                return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
            }
        });
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fullName", fullname);
        jsonObject.put("policyNumber", policyNumber);
        jsonObject.put("passportNumber", passportNumber);
        jsonObject.put("rememberMe", rememberMe);

        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);

        String url = this.url+"/api/authenticate/policy";

        try {
            ResponseEntity<String> responseEntityStr = restTemplate.
                    postForEntity(url, request, String.class);
            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                JSONObject res = new JSONObject(responseEntityStr.getBody());

                System.out.println(res.toString());
                String idToken = res.getString("id_token");
//                String userId = res.getString("user_id");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String policyNumberRes = res.getString("policyNumber");
                UserInfo userInfo = new UserInfo();
                try {
                    String travelAgentId = res.getString("travel_agent_id");
                    userInfo.setTravelAgentId(Integer.parseInt(travelAgentId));
                } catch (Exception e){}
                userInfo.setIdToken(idToken);
                userInfo.setUserId(null);
                userInfo.setFirstName(firstName);
                userInfo.setLastName(lastName);
                userInfo.setPolicyNumber(policyNumberRes);

                List<String> roles = new ArrayList<>();
                JSONArray jsonArray = res.getJSONArray("roles");
                for(int i=0; i<jsonArray.length(); i++){
                    String data = jsonArray.getString(i);
                    roles.add(data);
                }
                userInfo.setRole(roles);
                return userInfo;
            } else if (responseEntityStr.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                System.out.println("UNAUTHORIZED : "+responseEntityStr.getBody());
                JSONObject res = new JSONObject(responseEntityStr.getBody());

                String title = res.getString("title");
                if(title.contentEquals("locked")){
                    throw new LockedException("Your account is locked.");
                }
                else if(title.contentEquals("userLocked")){
                    throw new UserLockedException("Your account has been temporarily locked due to excessive failed login attempts. Please retry in 24 hours.");
                }
                else if(title.contentEquals("unlocked")){
                    throw new UnlockedException("Your account has been unlocked. Please login again.");
                }
                else if(title.contentEquals("badCredential")){
                    String detail = res.getString("detail");
                    throw new BadCredentialsException(detail);
                }
                else if(title.contentEquals("userNotFound")){
                    throw new UsernameNotFoundException("User does not exist.");
                }
            }
        } catch (Exception e){
            throw e;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
