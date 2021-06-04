package com.atibusinessgroup.bukutamu.service;

import com.atibusinessgroup.bukutamu.errors.UnlockedException;
import com.atibusinessgroup.bukutamu.errors.UserLockedException;
import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
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
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${app.backend.url}")
    private String url;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String[] usernameAndRememberme = StringUtils.split(
                authentication.getName(), String.valueOf(Character.LINE_SEPARATOR));
        String name ="";
        String password = authentication.getCredentials().toString();
        String rememberMe = "";
        if (usernameAndRememberme == null || usernameAndRememberme.length != 2) {
            throw new UsernameNotFoundException("Username not found");
        }

        name = usernameAndRememberme[0];
        rememberMe = usernameAndRememberme[1];

        try {
            UserInfo userInfo = shouldAuthenticateAgainstThirdPartySystem(name, password, Boolean.valueOf(rememberMe));
            if (userInfo != null) {
                // setup role disini
                List<GrantedAuthority> authorities = new ArrayList<>();
                for(String role : userInfo.getRole()) {
                    System.out.println("ROLE : "+role);
                    authorities.add(new SimpleGrantedAuthority(role));
                }
                return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
            } else {
                throw new BadCredentialsException("Bad credential");
            }
        }catch(Exception e){
            //System.out.println("MASUK SINI : "+e.getMessage());
            throw e;
        }
    }

    private UserInfo shouldAuthenticateAgainstThirdPartySystem(String username, String password, boolean rememberMe) {
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
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("rememberMe", rememberMe);

        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);

        String url = this.url+"/api/authenticate";

        try {
            ResponseEntity<String> responseEntityStr = restTemplate.
                    postForEntity(url, request, String.class);
            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                JSONObject res = new JSONObject(responseEntityStr.getBody());

                System.out.println(res.toString());
                String idToken = res.getString("id_token");
                String userId = res.getString("user_id");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                UserInfo userInfo = new UserInfo();
                try {
                    String travelAgentId = res.getString("travel_agent_id");
                    String travelAgentName = res.getString("travel_agent_name");
                    userInfo.setTravelAgentId(Integer.parseInt(travelAgentId));
                    userInfo.setTravelAgentName(travelAgentName);
                } catch (Exception e){}

                userInfo.setIdToken(idToken);
                userInfo.setUserId(userId);
                userInfo.setFirstName(firstName);
                userInfo.setLastName(lastName);
                List<String> roles = new ArrayList<>();
                JSONArray jsonArray = res.getJSONArray("roles");
                for(int i=0; i<jsonArray.length(); i++){
                    String data = jsonArray.getString(i);
                    roles.add(data);

                    if(data.contentEquals("ROLE_AMANYAMAN_SALES_CENTER")){
                        userInfo.setTravelAgentName("Contact Center Staff");
                    }
                    else if(data.contentEquals("ROLE_ADMIN")){
                        userInfo.setTravelAgentName("Administrator");
                    }
                    else if(data.contentEquals("ROLE_AZP")){
                        userInfo.setTravelAgentName("AZP");
                    }
                    else if(data.contentEquals("ROLE_BUSINESS_EXECUTIVE")){
                        userInfo.setTravelAgentName("Business Executive");
                    }
                    else if(data.contentEquals("ROLE_ETIQA")){
                        userInfo.setTravelAgentName("Etiqa");
                    }
                    else if(data.contentEquals("ROLE_FINANCE")){
                        userInfo.setTravelAgentName("Finance Manager");
                    }
                    else if(data.contentEquals("ROLE_IBS")){
                        userInfo.setTravelAgentName("IBS");
                    }
                    else if(data.contentEquals("ROLE_MANAGEMENT")){
                        userInfo.setTravelAgentName("Management");
                    }
                    else if(data.contentEquals("ROLE_OPERATION_MANAGER")){
                        userInfo.setTravelAgentName("Operation Manager");
                    }
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
