package com.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class BankAppSpringSecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	UserDetails user1=(UserDetails) User.builder().username("shiva").password("{noop}shiva").roles("EMP");
	auth.inMemoryAuthentication()
	.withUser("Shiva").password("{noop}shiva").roles("EMP");

}

}
