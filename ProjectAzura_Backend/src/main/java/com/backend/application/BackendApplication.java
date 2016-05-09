package com.backend.application;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot launcher for the backend server.
 * 
 * @author Gary McGuire
 *
 */
@SpringBootApplication
@RestController
@EnableResourceServer
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
//	@Bean
//	public HeaderHttpSessionStrategy sessionStategy() {
//		return new HeaderHttpSessionStrategy();
//	}
//	
	/**
	 * Home method setting mapping to "/" and adding CORS protocol
	 * 
	 * @return Message
	 */
	@RequestMapping("/")
//	@CrossOrigin(origins = "*", maxAge = 3600)
	public Message home() {
		return new Message("Hello World!");
	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic().disable();
//		http.authorizeRequests().anyRequest().authenticated();
//	}
	

	/**
	 * Small private class to compartmentalize the message creation in the
	 * home() method above.
	 * 
	 * @author Gary McGuire
	 *
	 */
	private class Message {
		private String id = UUID.randomUUID().toString();
		private String content;

		public Message(String content) {
			this.content = content;
		}

		public String getId() {
			return id;
		}

		public String getContent() {
			return content;
		}

	}

}
