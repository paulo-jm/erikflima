package com.guusto.buygift.config.security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.guusto.security.config.KeycloakSecurityConfig;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class BuyGiftSecurityConfig extends KeycloakSecurityConfig {

	public BuyGiftSecurityConfig(KeycloakClientRequestFactory keycloakClientRequestFactory) {
		super(keycloakClientRequestFactory);
	}

}
