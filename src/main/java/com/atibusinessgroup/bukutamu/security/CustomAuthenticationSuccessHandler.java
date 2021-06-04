package com.atibusinessgroup.bukutamu.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
//        for (GrantedAuthority auth : authentication.getAuthorities()) {
//            if ("ROLE_TRAVEL_AGENT".equals(auth.getAuthority())) {
//                response.sendRedirect("/create-quote/search");
//            }
//            else if ("ROLE_ETIQA".equals(auth.getAuthority())) {
//                response.sendRedirect("/reporting/etiqa/r1/list");
//            }
//            else if ("ROLE_IBS".equals(auth.getAuthority())) {
//                response.sendRedirect("/reporting/ibs/r1/list");
//            }
//            else if ("ROLE_OPERATION_MANAGER".equals(auth.getAuthority())) {
//                response.sendRedirect("/refund/list");
//            }
//            else {
//                response.sendRedirect("/policy/list");
//            }
//        }

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if("ROLE_MANAGEMENT".equals(auth.getAuthority())){
                response.sendRedirect("/notification/list");
            }
        }
        response.sendRedirect("/claim/list");
    }
}
