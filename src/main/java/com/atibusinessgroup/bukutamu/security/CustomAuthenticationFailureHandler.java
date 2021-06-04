package com.atibusinessgroup.bukutamu.security;

import com.atibusinessgroup.bukutamu.errors.UnlockedException;
import com.atibusinessgroup.bukutamu.errors.UserLockedException;
import com.atibusinessgroup.bukutamu.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
    	System.out.println("REQUEST URI AUTH FAILURE : "+request.getRequestURI());
        if(e instanceof UnlockedException){
            String message = e.getMessage();
            httpServletResponse.sendRedirect(request.getRequestURI()+"?unlocked");
        }
        else if(e instanceof LockedException){
            String message = e.getMessage();
            httpServletResponse.sendRedirect(request.getRequestURI()+"?locked");
        }
        else if(e instanceof UserLockedException){
            String message = e.getMessage();
            httpServletResponse.sendRedirect(request.getRequestURI()+"?userLocked");
        }
        else if(e instanceof UsernameNotFoundException) {
            String message = e.getMessage();
            httpServletResponse.sendRedirect(request.getRequestURI()+"?usernameNotFound");
        }
        else if(e instanceof BadCredentialsException){
            String message = e.getMessage();
            httpServletResponse.sendRedirect(request.getRequestURI()+"?badCredential="+message);
        }
    }

}
