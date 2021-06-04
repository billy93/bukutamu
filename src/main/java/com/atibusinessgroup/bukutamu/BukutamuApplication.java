package com.atibusinessgroup.bukutamu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.atibusinessgroup.bukutamu.errors.RestTemplateResponseErrorHandler;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.TimeZone;

@SpringBootApplication
public class BukutamuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BukutamuApplication.class, args);
	}

    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
//		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
//			public boolean hasError(ClientHttpResponse response) throws IOException {
//				HttpStatus statusCode = response.getStatusCode();
//				return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
//			}
//
//		});
		return restTemplate;
	}

//	private Connector redirectConnector() {
//	  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//	  connector.setScheme("http");
//	  connector.setPort(8078);
//	  connector.setSecure(false);
//	  connector.setRedirectPort(8078);
//
//	  return connector;
//	}
}
