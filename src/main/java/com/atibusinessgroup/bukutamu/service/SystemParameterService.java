package com.atibusinessgroup.bukutamu.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SystemParameterService extends AmanyamanService {

    public List<Object> getAllSystemParameter(SearchSystemParameterMasterDTO searchSystemParameterMasterDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/system-parameters?page="+searchSystemParameterMasterDTO.getPage()+"&size="+searchSystemParameterMasterDTO.getSize();

        try {
            ResponseEntity<List<SystemParameterDTO>> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<SystemParameterDTO>>() {
                }, new HashMap<>());
            String totalCount = responseEntityStr.getHeaders().getFirst("X-Total-Count");

            List<Object> results = new ArrayList<>();
            results.add(responseEntityStr.getBody());
            results.add(totalCount);

            return results;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public SystemParameterDTO getSystemParameterByName(String name){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/system-parameters?page=0&size=1";

        try {
            ResponseEntity<List<SystemParameterDTO>> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<SystemParameterDTO>>() {
                }, new HashMap<>());
            if(responseEntityStr.getStatusCode() == HttpStatus.OK && responseEntityStr.getBody().size() > 0) {
                return responseEntityStr.getBody().get(0);
            }
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public SystemParameterDTO getSystemParameterById(String id) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/system-parameters/"+id;

        try {
            ResponseEntity<SystemParameterDTO> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, SystemParameterDTO.class, new HashMap<>());
            if(responseEntityStr.getStatusCode() == HttpStatus.OK && responseEntityStr.getBody() != null) {
                return responseEntityStr.getBody();
            }
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public SystemParameterDTO updateSystemParameter(SystemParameterDTO systemParameterDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<SystemParameterDTO> request =
            new HttpEntity<SystemParameterDTO>(systemParameterDTO, headers);

        HttpMethod method = HttpMethod.POST;

        if(systemParameterDTO.getId() != null){
            method = HttpMethod.PUT;
        }

        System.out.println("Create/Update system parameter request : "+request.getBody());
        String url = this.url + "/api/system-parameters";
        try {
            ResponseEntity<SystemParameterDTO> responseEntity = restTemplate.
                exchange(url, method, request, SystemParameterDTO.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK || responseEntity.getStatusCode() == HttpStatus.CREATED) {
                SystemParameterDTO resultResponseDTO = responseEntity.getBody();
                return resultResponseDTO;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
