package com.greatlearning.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employee.service.UserServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Bean
	public UserDetailsService userDetailsService()
	{
		return new UserServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		dap.setPasswordEncoder(passwordEncoder());
		dap.setUserDetailsService(userDetailsService());

		return dap;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/employees/save","/employees/addEmployee","/employees/403").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/updateEmployee","/deleteEmployee").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/employees/403")
		.and()
		.cors().and().csrf().disable();
	}


}
