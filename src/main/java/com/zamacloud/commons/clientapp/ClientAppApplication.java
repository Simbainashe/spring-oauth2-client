package com.zamacloud.commons.clientapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@SpringBootApplication
@EnableOAuth2Sso
public class ClientAppApplication extends WebSecurityConfigurerAdapter {
	@Value("${auth-server-logout-url}")
	private String authServerLogoutUrl;
	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
	@Bean
	protected OAuth2RestTemplate OAuth2RestTemplate(
			OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
		return new OAuth2RestTemplate(resource, context);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**", "/error**")
				.permitAll().anyRequest()
				.authenticated().and().logout().logoutSuccessUrl(authServerLogoutUrl);
	}

}
