package com.dbs.ordermatching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dbs.ordermatching.filters.JWTRequestFilter;
import com.dbs.ordermatching.services.UserDetailService;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailService userdetailsservice;
	
	@Autowired
	private JWTRequestFilter jwtrequestfilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(userdetailsservice);
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.cors();
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET,"/init").permitAll()
		.antMatchers(HttpMethod.POST,"/authenticate").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		   
		   http.addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
//	@Bean
//	public PasswordEncoder getPasswordEncoded() {
//		return NoOpPasswordEncoder.getInstance();
//		
//	}
	
	
}
