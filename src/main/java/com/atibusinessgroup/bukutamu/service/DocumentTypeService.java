package com.atibusinessgroup.bukutamu.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.atibusinessgroup.bukutamu.model.UserInfo;
import com.atibusinessgroup.bukutamu.model.dto.ClaimTypeDTO;
import com.atibusinessgroup.bukutamu.model.dto.DocumentTypeDTO;

import java.util.HashMap;
import java.util.List;

@Service
public class DocumentTypeService extends AmanyamanService {

	public List<DocumentTypeDTO> getDocumentTypeByClaimType(String claimType) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		UserInfo userInfo = (UserInfo) usernamePasswordAuthenticationToken.getPrincipal();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(userInfo.getIdToken());

		HttpEntity entity = new HttpEntity(headers);

		String url = this.url + "/api/document-types?claimTypeId.equals="+claimType+"&page=0&size=9999";

		try {
			ResponseEntity<List<DocumentTypeDTO>> responseEntityStr = restTemplate.exchange(url, HttpMethod.GET, entity,
					new ParameterizedTypeReference<List<DocumentTypeDTO>>() {
					}, new HashMap<>());
			return responseEntityStr.getBody();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
