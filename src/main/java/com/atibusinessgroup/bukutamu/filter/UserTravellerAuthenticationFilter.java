package com.atibusinessgroup.bukutamu.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTravellerAuthenticationFilter
    extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(
        HttpServletRequest request,
        HttpServletResponse response)
        throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest
            = getAuthRequest(request);
        setDetails(request, authRequest);

        return this.getAuthenticationManager()
            .authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getAuthRequest(
        HttpServletRequest request) {

    	System.out.println("UserTravellerAuthenticationFilter");
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
        		
//        String usernameRememberme = String.format("%s%s%s", username.trim(),
//            String.valueOf(Character.LINE_SEPARATOR), rememberMe);

        return usernamePasswordAuthToken;
    }
}
