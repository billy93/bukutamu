package com.atibusinessgroup.bukutamu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.atibusinessgroup.bukutamu.model.CreateLodgeClaimForm;
import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.ClaimTypeDTO;

@Service
public class ClaimTypeService extends AmanyamanService {

	public List<ClaimTypeDTO> getClaimTypes() {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(userInfo.getIdToken());

		HttpEntity entity = new HttpEntity(headers);

		String url = this.url + "/api/claim-types?page=0&size=9999";

		try {
			ResponseEntity<List<ClaimTypeDTO>> responseEntityStr = restTemplate.exchange(url, HttpMethod.GET, entity,
					new ParameterizedTypeReference<List<ClaimTypeDTO>>() {
					}, new HashMap<>());
			return responseEntityStr.getBody();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
