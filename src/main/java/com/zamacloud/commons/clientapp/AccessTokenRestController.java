package com.zamacloud.commons.clientapp;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fact S Musingarimi
 * 2/28/19
 * 6:40 PM
 */
@RestController
public class AccessTokenRestController {
    private  final OAuth2RestTemplate oAuth2RestTemplate;

    public AccessTokenRestController(OAuth2RestTemplate oAuth2RestTemplate) {
        this.oAuth2RestTemplate = oAuth2RestTemplate;
    }

    @GetMapping("/token")
    public String getAccessToken(){
        return oAuth2RestTemplate.getAccessToken().getValue();
    }
}
