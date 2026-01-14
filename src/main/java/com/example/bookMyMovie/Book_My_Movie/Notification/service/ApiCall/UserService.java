package com.example.bookMyMovie.Book_My_Movie.Notification.service.ApiCall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${userUrl}")
    private String userUrl;


    public String getUserId(Long id){
        String url = userUrl+"/id/"+id ;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> requestBody = new HttpEntity<>(headers);
        log.info("URL :{}",url);
        ResponseEntity<String> userResponse=restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestBody,
                String.class
        );
        log.info("Response :{}",userResponse.getBody());
        return userResponse.getBody();
    }
}

