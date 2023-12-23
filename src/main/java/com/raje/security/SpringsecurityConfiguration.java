package com.raje.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringsecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// 1. all request should be authenticated
		/*http.authorizeRequests().
        anyRequest().denyAll().
        and().formLogin()
        .and().httpBasic();*/
		
		http.csrf().ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers(PathRequest.toH2Console()).and()
        .authorizeHttpRequests()
       
		
		//rest
		.requestMatchers("/rest/**").permitAll()
		.requestMatchers("/question/**").permitAll()
		.requestMatchers("/quiz/**").permitAll()
		
		//UI
		
		.requestMatchers("/dashboard").authenticated()
		
		 .requestMatchers("/displayMessages").hasRole("ADMIN")
         .requestMatchers("/closeMsg/**").hasRole("ADMIN")
         
		
		.requestMatchers("/home").permitAll()
        .requestMatchers("/holidays/**").permitAll()
        .requestMatchers("/contact").permitAll()
        .requestMatchers("/saveMsg").permitAll()
        .requestMatchers("/courses").permitAll()
        .requestMatchers("/about").permitAll()
        .requestMatchers("/assets/**").permitAll()
        .requestMatchers("/login").permitAll()
        .requestMatchers("/logout").permitAll()
        .requestMatchers(PathRequest.toH2Console()).permitAll() //h2 console 
        
        .and().formLogin().loginPage("/login")
        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
        .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
        .and().httpBasic();

		 http.headers().frameOptions().disable(); // so we can see the ui of h2 console
		 
		return http.build();
	}


	@Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("user")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
