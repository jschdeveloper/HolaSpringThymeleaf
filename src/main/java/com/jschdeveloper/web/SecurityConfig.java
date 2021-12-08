package com.jschdeveloper.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()//
				.withUser("admin")//
				// no encripta el password
				.password("{noop}123")//
				.roles("ADMIN", "USER")//
				.and()//
				.withUser("user")//
				.password("{noop}123")//
				.roles("USER");

	}

}
