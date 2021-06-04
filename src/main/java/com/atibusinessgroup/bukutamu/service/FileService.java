/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.AreaGroupDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchPolicyListDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Service
public class FileService extends AmanyamanService{

    public Resource downloadProductBrochure(String productId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/product/brochure/files/"+productId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }



    public String uploadProductBrochure(String productId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/product/brochure/"+productId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Resource downloadProductWording(String productId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/product/wording/files/"+productId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String uploadProductWording(String productId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/product/wording/"+productId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Resource downloadPolicy(String salesTravelId, String travellerId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/policy/files/merge/"+salesTravelId+"/"+travellerId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Resource downloadFullComparison() {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/product/full-comparison/files/download";

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String uploadClaimDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/expense-document/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadClaimApproveDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/approve/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadClaimApproveAppealDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/approve-appeal/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String uploadClaimRejectDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/reject/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadClaimPayDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/pay/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadClaimLODDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/lod/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadClaimAppealDocument(String claimId, MultipartFile file) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(userInfo.getIdToken());

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

            String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/appeal/"+claimId;

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Resource downloadExpenseDocument(String claimId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/expense-document/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Resource downloadAppealDocument(String claimId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/appeal/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    class MultipartInputStreamFileResource extends InputStreamResource {

        private final String filename;

        MultipartInputStreamFileResource(InputStream inputStream, String filename) {
            super(inputStream);
            this.filename = filename;
        }

        @Override
        public String getFilename() {
            return this.filename;
        }

        @Override
        public long contentLength() throws IOException {
            return -1; // we do not want to generally read the whole stream into memory ...
        }
    }

	public Resource downloadApproveDocument(String claimId, String filename) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/approve/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}



	public Resource downloadRejectDocument(String claimId, String filename) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/reject/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}



	public Resource downloadPaidDocument(String claimId, String filename) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/pay/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}


	public Resource downloadLODDocument(String claimId, String filename) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/lod/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

	public Resource downloadApproveAppealDocument(String claimId, String filename) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Resource> entity = new HttpEntity(headers);
        String url = this.url+"/services/amanyaman-files/api/file-upload/lodge-claim/approve-appeal/files/"+claimId+"/"+filename;

        try {
            ResponseEntity<Resource> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, Resource.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}
}
