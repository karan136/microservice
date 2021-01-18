package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javainuse.filter.ErrorFilter;
import com.javainuse.filter.PostFilter;
import com.javainuse.filter.PreFilter;
import com.javainuse.filter.RouteFilter;
import com.javainuse.security.JwtAuthenticationFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringBootHelloWorldApplicationZuulService {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplicationZuulService.class, args);
	}
/*
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // For encrypting user password
    }
	@Bean
    public JwtAuthenticationFilter getJwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(); // For encrypting user password
    }
*/	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}