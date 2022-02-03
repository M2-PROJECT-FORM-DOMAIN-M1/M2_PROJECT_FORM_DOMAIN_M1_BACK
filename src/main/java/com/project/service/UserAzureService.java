package com.project.service;

import com.project.models.UserAzure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class UserAzureService {

    private static final Logger logger = LoggerFactory.getLogger(UserAzureService.class);


    public UserAzure getUserAzure(String email,String token) throws Exception {
        String url = "https://graph.microsoft.com/v1.0/users/"+email;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer "+token);

        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        UserAzure response;

        logger.debug("Email = " + email +"    token =" + token  );
        try{
            return restTemplate.exchange(url, HttpMethod.GET, request, UserAzure.class).getBody();
        }catch (Exception e){
            throw new Exception(e);
        }

    }

}
