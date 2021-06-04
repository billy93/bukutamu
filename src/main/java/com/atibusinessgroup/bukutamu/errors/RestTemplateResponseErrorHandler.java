package com.atibusinessgroup.bukutamu.errors;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler
    implements ResponseErrorHandler {

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
        throws IOException {

        return (
            httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
        throws IOException {

        System.out.println(httpResponse.getStatusCode());
        if (httpResponse.getStatusCode()
            .series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode()
            .series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
//                System.out.println("UNAUTHORIZED, AUTO LOGOUT");
                SecurityContextHolder.getContext().setAuthentication(null);
//                SecurityContextHolder.clearContext();
            }
        }
    }
}
