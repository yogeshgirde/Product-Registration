package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	@Autowired
	private UserDetailsService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service)
		.passwordEncoder(pwdEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		.authorizeRequests()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/product/register","/product/save").hasAuthority("ADMIN")
		.antMatchers("/product/all","/product/delete").hasAnyAuthority("ADMIN","EMP")
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/user/login")
		.defaultSuccessUrl("/product/all",true)
		
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/user/login?logout=true")

		.and()
		.exceptionHandling()
		.accessDeniedPage("/user/denied")
		
		;
	}
	
	
	
	
	
	
}
