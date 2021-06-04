package com.atibusinessgroup.bukutamu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.atibusinessgroup.bukutamu.model.UserInfo;

import javax.servlet.http.HttpSession;

@Service
public class AmanyamanService {

    @Value("${app.backend.url}")
    protected String url;
    @Autowired
    protected RestTemplate restTemplate;

}