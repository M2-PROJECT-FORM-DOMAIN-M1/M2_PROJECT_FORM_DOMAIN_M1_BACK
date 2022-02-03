package com.project.session;

import com.project.models.UserAzure;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
public class UserAzureSession {

    @Bean
    @SessionScope
    public UserAzure userAzure() {
        return new UserAzure();
    }


}
