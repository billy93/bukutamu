/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.atibusinessgroup.bukutamu.model.*;
import com.atibusinessgroup.bukutamu.model.dto.TOPCheckCreditLimitDTO;
import com.atibusinessgroup.bukutamu.model.dto.TravelSearchResultResponseDTO;

import java.text.SimpleDateFormat;
import java.util.HashMap;

@Service
public class UpgradePolicyService extends AmanyamanService {


    public TravelSearchResultResponseDTO searchTravelInsuranceProduct(SearchForm searchForm) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(userInfo.getIdToken());
        JSONObject jsonObject = new JSONObject();

        if (searchForm.getId() != null) {
            jsonObject.put("id", searchForm.getId());
        }

        String planType = searchForm.getPlanType();
        if (planType.contentEquals("single")) {
            jsonObject.put("coverType", "SINGLE_TRIP");
        } else if (planType.contentEquals("annual")) {
            jsonObject.put("coverType", "ANNUAL");
        }

        String coverType = searchForm.getTravellerType();
        if (coverType.contentEquals("individual")) {
            jsonObject.put("planType", "INDIVIDUAL");
        } else if (coverType.contentEquals("family")) {
            jsonObject.put("planType", "FAMILY");
        }

        if(searchForm.getDestinations() != null && searchForm.getDestinations().size() > 0) {
            JSONArray destinations = new JSONArray();
            for (String dest : searchForm.getDestinations()) {
                JSONObject d = new JSONObject();
                d.put("name", dest);
                d.put("type", "COUNTRY");
                destinations.put(d);
            }
            jsonObject.put("destination", destinations);
        }

        JSONArray travellers = new JSONArray();
        JSONObject adt = new JSONObject();
        adt.put("size", searchForm.getAdult());
        adt.put("type", "ADT");
        JSONObject chd = new JSONObject();
        chd.put("size", searchForm.getChild());
        chd.put("type", "CHD");
        travellers.put(adt);
        travellers.put(chd);

        jsonObject.put("travellers", travellers);
        jsonObject.put("pageNumber", 0);
        jsonObject.put("pageSize", 30);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        jsonObject.put("from", format.format(searchForm.getStartDate()));
        jsonObject.put("to", format.format(searchForm.getEndDate()));

        String httpRequest = jsonObject.toString();
        System.out.println("Search request : "+httpRequest);
        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);

        String url = this.url + "/services/amanyaman-sales-travel-insurance/api/sales-travel-insurance/search-product";
        try {
            ResponseEntity<TravelSearchResultResponseDTO> responseEntity = restTemplate.
                    postForEntity(url, request, TravelSearchResultResponseDTO.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                TravelSearchResultResponseDTO resultResponseDTO = responseEntity.getBody();
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