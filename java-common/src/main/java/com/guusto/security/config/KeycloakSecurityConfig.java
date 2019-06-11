package com.guusto.security.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

public abstract class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

	private final KeycloakClientRequestFactory keycloakClientRequestFactory;

	public KeycloakSecurityConfig(KeycloakClientRequestFactory keycloakClientRequestFactory) {
		this.keycloakClientRequestFactory = keycloakClientRequestFactory;

		// to use principal and authentication together with @async
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);

	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public KeycloakRestTemplate keycloakRestTemplate() {
		return new KeycloakRestTemplate(keycloakClientRequestFactory);
	}

	/**
	 * registers the Keycloakauthenticationprovider in spring context and sets its
	 * mapping strategy for roles/authorities (mapping to spring seccurities'
	 * default ROLE_... for authorities ).
	 * 
	 * @param auth SecurityBuilder to build authentications and add details like
	 *             authproviders etc.
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		KeycloakAuthenticationProvider keyCloakAuthProvider = keycloakAuthenticationProvider();
		keyCloakAuthProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());

		auth.authenticationProvider(keyCloakAuthProvider);
	}

	/**
	 * Sets keycloaks config resolver to use springs application.properties instead
	 * of keycloak.json (which is standard)
	 * 
	 * @return
	 */
	@Bean
	public KeycloakConfigResolver KeyCloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

	/**
	 * define the session auth strategy so that no session is created
	 * 
	 * @return concrete implementation of session authentication strategy
	 */
	@Bean
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new NullAuthenticatedSessionStrategy();
	}

	/**
	 * define the actual constraints of the app.
	 * 
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.cors()
			.and()
			.csrf()
			.disable()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.sessionAuthenticationStrategy(sessionAuthenticationStrategy())
			.and()
			.authorizeRequests();
	}

	@Bean
	public FilterRegistrationBean<KeycloakAuthenticationProcessingFilter> keycloakAuthenticationProcessingFilterRegistrationBean(
			KeycloakAuthenticationProcessingFilter filter) {
		FilterRegistrationBean<KeycloakAuthenticationProcessingFilter> registrationBean = new FilterRegistrationBean<KeycloakAuthenticationProcessingFilter>(
				filter);
		registrationBean.setEnabled(false);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<KeycloakPreAuthActionsFilter> keycloakPreAuthActionsFilterRegistrationBean(
			KeycloakPreAuthActionsFilter filter) {
		FilterRegistrationBean<KeycloakPreAuthActionsFilter> registrationBean = new FilterRegistrationBean<KeycloakPreAuthActionsFilter>(
				filter);
		registrationBean.setEnabled(false);
		return registrationBean;
	}

}