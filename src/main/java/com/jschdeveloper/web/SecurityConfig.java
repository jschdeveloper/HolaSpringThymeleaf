package com.jschdeveloper.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// agregar nuevos usuarios = autenticación
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// asegurar nuestras URL = autorizacion
		http.authorizeRequests()//
				.antMatchers("/editar/**", "/agregar/**", "/eliminar")//
					.hasRole("ADMIN")//
				.antMatchers("/")//
					.hasAnyRole("USER", "ADMIN")//
				.and()//
					.formLogin()//
					.loginPage("/login")//
				.and()//
					.exceptionHandling()//
					.accessDeniedPage("/errores/403");
	}

}
