package com.atibusinessgroup.bukutamu.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.atibusinessgroup.bukutamu.model.ResetPasswordForm;
import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.*;

import java.io.IOException;
import java.util.*;

@Service
public class UserService extends AmanyamanService{

    public UserDTO findByLogin(String login){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo curUser = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(curUser.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String userUrl = this.url+"/api/users/travel-agent/"+login;

        try {
            ResponseEntity<UserDTO> responseEntityStr = restTemplate.exchange(
                userUrl, HttpMethod.GET, entity, UserDTO.class, new HashMap<>());

            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                return responseEntityStr.getBody();
            } else {

            }
        } catch (Exception e){
            return null;
        }

        return null;
    }

    public UserInfo checkUserLoginById(String userId){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo curUser = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(curUser.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String userUrl = this.url+"/api/users/getById/"+userId;

        try {
            ResponseEntity<String> responseEntityStr = restTemplate.exchange(
                    userUrl, HttpMethod.GET, entity, String.class, new HashMap<>());

            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                JSONObject response = new JSONObject(responseEntityStr.getBody());
                UserInfo userInfo = new UserInfo();
                userInfo.setEmail(response.getString("email"));
                userInfo.setFirstName(response.getString("firstName"));
                userInfo.setLastName(response.getString("lastName"));

                JSONArray auth = response.getJSONArray("authorities");
                List<String> roles = new ArrayList<>();
                for (int i = 0; i < auth.length(); i++) {
                    roles.add(String.valueOf(auth.get(i)));
                }
                userInfo.setRole(roles);
                userInfo.setLogin(response.getString("login"));
                userInfo.setUserId(response.getString("id"));
                return userInfo;
            } else {

            }
        } catch (Exception e){
            return null;
        }

        return null;
    }

    public UserInfo checkUserLogin(String username){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        String userUrl = this.url+"/api/users/"+username;

        try {
            ResponseEntity<String> responseEntityStr = restTemplate.exchange(
                    userUrl, HttpMethod.GET, entity, String.class, new HashMap<>());

            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                JSONObject response = new JSONObject(responseEntityStr.getBody());
                UserInfo userInfo = new UserInfo();
                userInfo.setEmail(response.getString("email"));
                userInfo.setFirstName(response.getString("firstName"));
                userInfo.setLastName(response.getString("lastName"));

                JSONArray auth = response.getJSONArray("authorities");
                List<String> roles = new ArrayList<>();
                for (int i = 0; i < auth.length(); i++) {
                    roles.add(String.valueOf(auth.get(i)));
                }
                userInfo.setRole(roles);
                userInfo.setLogin(response.getString("login"));
                userInfo.setUserId(response.getString("id"));
                return userInfo;
            } else {

            }
        }
        catch (Exception e){
            return null;
        }

        return null;
    }

    public UserInfo checkUserLoginByEmail(String email){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        String userUrl = this.url+"/api/users/getByEmail/"+email;

        try {
            ResponseEntity<String> responseEntityStr = restTemplate.exchange(
                userUrl, HttpMethod.GET, entity, String.class, new HashMap<>());

            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                JSONObject response = new JSONObject(responseEntityStr.getBody());
                UserInfo userInfo = new UserInfo();
                userInfo.setEmail(response.getString("email"));
                userInfo.setFirstName(response.getString("firstName"));
                userInfo.setLastName(response.getString("lastName"));

                JSONArray auth = response.getJSONArray("authorities");
                List<String> roles = new ArrayList<>();
                for (int i = 0; i < auth.length(); i++) {
                    roles.add(String.valueOf(auth.get(i)));
                }
                userInfo.setRole(roles);
                userInfo.setLogin(response.getString("login"));
                userInfo.setUserId(response.getString("id"));
                return userInfo;
            } else {

            }
        }
        catch (Exception e){
            return null;
        }

        return null;
    }

    public boolean sendForgetPasswordEmail(String email){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<String>(email, headers);

        String url = this.url+"/api/account/reset-password/init";
        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity(url, request, String.class);

        if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
            System.out.println("Sukses kirim email ke url : "+url);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean resetPassword(ResetPasswordForm resetPasswordForm) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", resetPasswordForm.getKey());
        jsonObject.put("newPassword", resetPasswordForm.getPassword());

        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);

        String url = this.url+"/api/account/reset-password/finish";
        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity(url, request, String.class);

        if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
            return true;
        }
        else{
            return false;
        }
    }

    public List<Object> getAllUsers(SearchUserMasterDTO searchUserMasterDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/users/search";

        System.out.println("Get all users : "+url);
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("page", searchUserMasterDTO.getPage().get());
            builder.queryParam("size", searchUserMasterDTO.getSize().get());
            builder.queryParam("sort", "createdDate,desc");
            if(searchUserMasterDTO.getEmail().isPresent()) {
                if(!searchUserMasterDTO.getEmail().get().contentEquals("")) {
                    builder.queryParam("email.contains", searchUserMasterDTO.getEmail().get());
                }
            }
            if(searchUserMasterDTO.getFullname().isPresent()) {
                if(!searchUserMasterDTO.getFullname().get().contentEquals("")) {
                    builder.queryParam("fullname.contains", searchUserMasterDTO.getFullname().get());
                }
            }
            if(searchUserMasterDTO.getRole().isPresent()) {
                if(!searchUserMasterDTO.getRole().get().contentEquals("")) {
                    builder.queryParam("role.equals", searchUserMasterDTO.getRole().get());
                }
            }

            System.out.println(builder.toUriString());
            ResponseEntity<List<UserDTO>> responseEntityStr = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<UserDTO>>() {
                }, new HashMap<>());

            String totalCount = responseEntityStr.getHeaders().getFirst("X-Total-Count");
            System.out.println("TOTAL COUNT : "+totalCount);
            System.out.println("USER SIZE : "+responseEntityStr.getBody().size());

            List<UserDTO> list = responseEntityStr.getBody();
            List<Object> results = new ArrayList<>();
            results.add(list);
            results.add(totalCount);
            return results;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public UserDTO createUpdateUser(UserDTO userDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        userDTO.setLogin(UUID.randomUUID().toString());
        HttpEntity<UserDTO> entity = new HttpEntity(userDTO, headers);
        String url = this.url+"/api/users/create";
        boolean update = false;
        if(userDTO.getId() != null){
            url = this.url+"/api/users/update";
            update = true;
        }
        try {
            ResponseEntity<UserDTO> responseEntityStr = restTemplate.exchange(
                url, update ? HttpMethod.PUT : HttpMethod.POST, entity, UserDTO.class, new HashMap<>());
            if(responseEntityStr.getStatusCode() == HttpStatus.OK) {
                UserDTO user = responseEntityStr.getBody();
                System.out.println("Sukses create/update user");
                System.out.println(user);
                return user;
            }
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteUser(String login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<UserDTO> entity = new HttpEntity( headers);
        String url = this.url+"/api/users/"+login;

        try {
            ResponseEntity<Void> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.DELETE, entity, Void.class, new HashMap<>());
            if(responseEntityStr.getStatusCode() == HttpStatus.OK) {
                System.out.println("Sukses delete user");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Resource exportUserList(SearchUserMasterDTO searchUserMasterDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        JSONObject exportObject = new JSONObject();

        if(searchUserMasterDTO.getEmail().isPresent() && searchUserMasterDTO.getEmail().get() != null && !searchUserMasterDTO.getEmail().get().contentEquals("")) {
            JSONObject em = new JSONObject();
            em.put("contains", searchUserMasterDTO.getEmail().get());
            exportObject.put("email", em);
        }
        if(searchUserMasterDTO.getRole().isPresent() && searchUserMasterDTO.getRole().get() != null && !searchUserMasterDTO.getRole().get().contentEquals("")) {
            JSONObject em = new JSONObject();
            em.put("equals", searchUserMasterDTO.getRole().get());
            exportObject.put("role", em);
        }
        if(searchUserMasterDTO.getFullname().isPresent() && searchUserMasterDTO.getFullname().get() != null && !searchUserMasterDTO.getFullname().get().contentEquals("")) {
            JSONObject em = new JSONObject();
            em.put("contains", searchUserMasterDTO.getFullname().get());
            exportObject.put("fullname", em);
        }

//        List<String> sorts = new ArrayList<>();
//        sorts.add("createdDate,desc");
//        exportObject.put("sort", sorts);

        HttpEntity<String> entity = new HttpEntity(exportObject.toString(), headers);

        System.out.println(exportObject.toString());
        String url = this.url+"/api/users/list/export?page=0&size=99999&sort=createdDate,desc";

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.POST, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void importUserData(MultipartFile files) throws IOException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition
            .builder("form-data")
            .name("file")
            .filename("userdata")
            .build();
        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        HttpEntity<byte[]> fileEntity = new HttpEntity<>(files.getBytes(), fileMap);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileEntity);

        String url = this.url+"/api/users/list/import";

        HttpEntity<MultiValueMap<String, Object>> requestEntity =
            new HttpEntity<>(body, headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    public UserDTO findById(String userId) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo curUser = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(curUser.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String userUrl = this.url+"/api/users/getById/"+userId;

        try {
            ResponseEntity<UserDTO> responseEntityStr = restTemplate.exchange(
                userUrl, HttpMethod.GET, entity, UserDTO.class, new HashMap<>());

            if (responseEntityStr.getStatusCode() == HttpStatus.OK) {
                return responseEntityStr.getBody();
            } else {

            }
        } catch (Exception e){
            return null;
        }

        return null;
    }

    public void updateLatestFeed() {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo curUser = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(curUser.getIdToken());

        HttpEntity entity = new HttpEntity(curUser, headers);
        String userUrl = this.url+"/api/users/update-latest-feed";

        try {
            ResponseEntity<UserDTO> responseEntityStr = restTemplate.exchange(
                userUrl, HttpMethod.PUT, entity, UserDTO.class, new HashMap<>());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
