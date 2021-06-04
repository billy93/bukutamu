package com.atibusinessgroup.bukutamu.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleAuthenticationFilter
    extends UsernamePasswordAuthenticationFilter {

    public static final String SPRING_SECURITY_FORM_REMEMBERME_KEY = "rememberMe";

    @Override
    public Authentication attemptAuthentication(
        HttpServletRequest request,
        HttpServletResponse response)
        throws AuthenticationException {
    	
    	System.out.println("SIMPLE FILTER GET AUTH REQUEST "+request.getMethod());
        UsernamePasswordAuthenticationToken authRequest
            = getAuthRequest(request);
        setDetails(request, authRequest);

        return this.getAuthenticationManager()
            .authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getAuthRequest(
        HttpServletRequest request) {

    	System.out.println("FILTER SIMPLE");
        String username = obtainUsername(request);
        if(username != null && !username.contentEquals("")) {
	        String password = obtainPassword(request);
	        String rememberMe = obtainRememberMe(request);
	
	        if(rememberMe != null){
	            rememberMe = "true";
	        }
	        else{
	            rememberMe = "false";
	        }
	
	        String usernameRememberme = String.format("%s%s%s", username.trim(),
	            String.valueOf(Character.LINE_SEPARATOR), rememberMe);
	
	        return new UsernamePasswordAuthenticationToken(
	            usernameRememberme, password);
        }
        else {
        	String fullName = request.getParameter("fullName");
            String policyNumber = request.getParameter("policyNumber");
            String passportNumber = request.getParameter("passportNumber");
            String rememberMe = "true";

            String principal = String.format("%s%s%s%s%s",
            		fullName,
                    ",",
                    policyNumber,
                    ",",
                    passportNumber
                );
        	UsernamePasswordAuthenticationToken usernamePasswordAuthToken = new UsernamePasswordAuthenticationToken(principal, "");
        	return usernamePasswordAuthToken;
        }
    }

    // other methods
    private String obtainRememberMe(HttpServletRequest request) {
        return request.getParameter(SPRING_SECURITY_FORM_REMEMBERME_KEY);
    }
}
