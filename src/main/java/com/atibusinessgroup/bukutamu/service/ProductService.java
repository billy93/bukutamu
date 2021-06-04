package com.atibusinessgroup.bukutamu.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService extends AmanyamanService {

    public List<ProductDTO> getProducts(){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/products/travel-agent/all/"+userInfo.getTravelAgentId();

        System.out.println("Get products : "+url);
        try {
            ResponseEntity<List<ProductDTO>> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ProductDTO>>() {
                }, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public List<ProductDTO> getAllProducts(){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/products?page=0&size=99999";

        System.out.println("Get products : "+url);
        try {
            ResponseEntity<List<ProductDTO>> responseEntityStr = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ProductDTO>>() {
                }, new HashMap<>());
            System.out.println("SIZE PRODUCTS : "+responseEntityStr.getBody().size());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Object> getAllProducts(SearchProductMasterDTO searchProductMasterDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/products?page="+searchProductMasterDTO.getPage().get()+"&size="+searchProductMasterDTO.getSize().get();

        System.out.println("Get all products : "+url);
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            if(searchProductMasterDTO.getProductDtlCode().isPresent()) {
                builder.queryParam("productDtlCode.contains", searchProductMasterDTO.getProductDtlCode().get());
            }
            ResponseEntity<List<ProductMasterDTO>> responseEntityStr = restTemplate.exchange(
                    builder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<ProductMasterDTO>>() {
                    }, new HashMap<>());

            String totalCount = responseEntityStr.getHeaders().getFirst("X-Total-Count");
            System.out.println("TOTAL COUNT : "+totalCount);
            System.out.println("PRODUCT SIZE : "+responseEntityStr.getBody().size());

            List<ProductMasterDTO> list = responseEntityStr.getBody();

            List<Object> results = new ArrayList<>();
            results.add(list);
            results.add(totalCount);
            return results;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Object> getAllTravelAgentProducts(SearchProductMasterAgentDTO searchProductMasterAgentDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);


        String url = this.url+"/api/products/travel-agent/"+userInfo.getTravelAgentId()+"?page=0&size=99999";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("areaGroupId.equals", searchProductMasterAgentDTO.getPlanType().isPresent() && !searchProductMasterAgentDTO.getPlanType().get().contentEquals("") ? searchProductMasterAgentDTO.getPlanType().get().substring(0,1) : null)
            .queryParam("productTypeId.equals", searchProductMasterAgentDTO.getTravellerType().isPresent() ? searchProductMasterAgentDTO.getTravellerType().get() : null)
            .queryParam("travelDurationId.equals", searchProductMasterAgentDTO.getTripType().isPresent() ? searchProductMasterAgentDTO.getTripType().get() : null)
            .queryParam("planTypeNum.equals", searchProductMasterAgentDTO.getPlanType().isPresent() && !searchProductMasterAgentDTO.getPlanType().get().contentEquals("") ? readPlanType(searchProductMasterAgentDTO.getPlanType().get().substring(1,2)) : null);

        //?page="+searchProductMasterAgentDTO.getPage().get()+"&size="+searchProductMasterAgentDTO.getSize().get();

        System.out.println("Get all travel agent products : "+url);
        try {
            ResponseEntity<List<TravelAgentProductDataDTO>> responseEntityStr = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<TravelAgentProductDataDTO>>() {
                    }, new HashMap<>());

            String totalCount = responseEntityStr.getHeaders().getFirst("X-Total-Count");
            System.out.println("TOTAL COUNT : "+totalCount);
            System.out.println("PRODUCT SIZE : "+responseEntityStr.getBody().size());

            List<TravelAgentProductDataDTO> list = responseEntityStr.getBody();

            List<Object> results = new ArrayList<>();
            results.add(list);
            results.add(totalCount);
            return results;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String readPlanType(String s) {
        if(s.contentEquals("1")){
            return "50";
        }
        else if(s.contentEquals("2")){
            return "100";
        }
        else if(s.contentEquals("3")){
            return "250";
        }
        return "";
    }

    public List<Object> getAllTravelAgentProductPrices(SearchProductMasterAgentPricesDTO searchProductMasterAgentPricesDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        try {
            String url = this.url+"/api/travel-agent-products-search";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("page", searchProductMasterAgentPricesDTO.getPage().get());
            builder.queryParam("size", searchProductMasterAgentPricesDTO.getSize().get());
//            builder.queryParam("sort", "createdDate,desc");

            if(searchProductMasterAgentPricesDTO.getTravellerType().isPresent()){
                if(!searchProductMasterAgentPricesDTO.getTravellerType().get().contentEquals("")){
                    builder.queryParam("productTypeId.equals",
                        searchProductMasterAgentPricesDTO.getTravellerType().isPresent() ? searchProductMasterAgentPricesDTO.getTravellerType().get() : null);
                }
                if(!searchProductMasterAgentPricesDTO.getTripType().get().contentEquals("")){
                    builder.queryParam("travelDurationId.equals",
                        searchProductMasterAgentPricesDTO.getTripType().isPresent() ? searchProductMasterAgentPricesDTO.getTripType().get() : null);
                }
                if(!searchProductMasterAgentPricesDTO.getPlanType().get().contentEquals("")){
                    builder.queryParam("areaGroupId.equals",
                        searchProductMasterAgentPricesDTO.getPlanType().isPresent() ? searchProductMasterAgentPricesDTO.getPlanType().get().substring(0,1) : null);
                }
                if(!searchProductMasterAgentPricesDTO.getTravelAgentName().get().contentEquals("")){
                    builder.queryParam("travelAgentName.contains",
                        searchProductMasterAgentPricesDTO.getTravelAgentName().isPresent() ? searchProductMasterAgentPricesDTO.getTravelAgentName().get() : null);
                }
            }
            System.out.println(builder.toUriString());

            ResponseEntity<List<TravelAgentProductDTO>> responseEntityStr = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<TravelAgentProductDTO>>() {
                }, new HashMap<>());

            String totalCount = responseEntityStr.getHeaders().getFirst("X-Total-Count");
            System.out.println("TOTAL COUNT : "+totalCount);
            System.out.println("PRODUCT SIZE : "+responseEntityStr.getBody().size());

            List<TravelAgentProductDTO> list = responseEntityStr.getBody();

            List<Object> results = new ArrayList<>();
            results.add(list);
            results.add(totalCount);
            return results;
        } catch (Exception e){
            return null;
        }
    }

    public TravelAgentProductDTO getTravelAgentProductPrice(String id){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/travel-agent-products/"+id;
        //?page="+searchProductMasterAgentDTO.getPage().get()+"&size="+searchProductMasterAgentDTO.getSize().get();

        System.out.println("Get travel agent product price : "+url);
        try {
            ResponseEntity<TravelAgentProductDTO> responseEntityStr = restTemplate.exchange(
                    url, HttpMethod.GET, entity, TravelAgentProductDTO.class, new HashMap<>());

            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ProductMasterDTO getProduct(String id) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity entity = new HttpEntity(headers);

        String url = this.url+"/api/products/"+id;

        System.out.println("Get product : "+url);
        try {
            ResponseEntity<ProductMasterDTO> responseEntityStr = restTemplate.exchange(
                    url, HttpMethod.GET, entity,ProductMasterDTO.class, new HashMap<>());
            return responseEntityStr.getBody();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ProductDTO updateProduct(ProductMasterDTO productMasterDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        if(productMasterDTO.getProductAdditionalWeek() != null){
            if(productMasterDTO.getProductAdditionalWeek().getId() == null){
                productMasterDTO.setProductAdditionalWeek(null);
            }
        }
        HttpEntity<ProductMasterDTO> request =
            new HttpEntity<ProductMasterDTO>(productMasterDTO, headers);

        System.out.println("Update product request : "+request.getBody());
        String url = this.url + "/api/products";
        try {
            ResponseEntity<ProductDTO> responseEntity = restTemplate.
                exchange(url, HttpMethod.PUT, request, ProductDTO.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ProductDTO resultResponseDTO = responseEntity.getBody();
                return resultResponseDTO;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ProductDTO updateProductBrochure(String productId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Void> request =
            new HttpEntity<Void>(headers);

        System.out.println("Update product request : "+request.getBody());
        String url = this.url + "/api/products/update/brochure/"+productId+"/"+filename;
        try {
            ResponseEntity<ProductDTO> responseEntity = restTemplate.
                exchange(url, HttpMethod.PUT, request, ProductDTO.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ProductDTO resultResponseDTO = responseEntity.getBody();
                return resultResponseDTO;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ProductDTO updateProductWording(String productId, String filename) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());

        HttpEntity<Void> request =
            new HttpEntity<Void>(headers);

        System.out.println("Update product request : "+request.getBody());
        String url = this.url + "/api/products/update/wording/"+productId+"/"+filename;
        try {
            ResponseEntity<ProductDTO> responseEntity = restTemplate.
                exchange(url, HttpMethod.PUT, request, ProductDTO.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ProductDTO resultResponseDTO = responseEntity.getBody();
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
