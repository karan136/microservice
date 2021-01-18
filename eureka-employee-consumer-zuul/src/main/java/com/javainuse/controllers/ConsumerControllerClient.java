package com.javainuse.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient {
	Logger logger = LoggerFactory.getLogger(ConsumerControllerClient.class);
	@Autowired
	private DiscoveryClient discoveryClient;


	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET,headers = {"accept=application/json"})
	public String getEmployee(@RequestHeader(value="Authorization") String authorizationHeader) throws RestClientException, IOException {

		List<ServiceInstance> instances = discoveryClient.getInstances("EMPLOYEE-ZUUL-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/producer/employee";

		ResponseEntity<String> response = null;
		try {
			logger.info("BASEURL::::"+baseUrl);
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(authorizationHeader), String.class);
		} catch (Exception ex) {
			ex.fillInStackTrace();
		}
		logger.info(response.getBody());
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders(String auth) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", auth);
		return new HttpEntity<>(headers);
	}
}