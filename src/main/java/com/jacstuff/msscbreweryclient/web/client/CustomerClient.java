package com.jacstuff.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jacstuff.msscbreweryclient.web.model.CustomerDto;

@Component
@ConfigurationProperties("sfg.customer")
public class CustomerClient {
	
	String apihost;
	private final String CUSTOMER_V1_PATH = "/api/v1/customer/";
	RestTemplate restTemplate; 

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public void setApiHost(String apihost) {
		this.apihost = apihost;
	}
	
	public CustomerDto getCustomerById(UUID uuid) {
		return restTemplate.getForObject(getCustomerUrlFor(uuid), CustomerDto.class);
	}
	
	public URI addNewCustomer(CustomerDto customerDto) {
		return restTemplate.postForLocation(getCustomerUrl(), customerDto);
	}
	
	public void updateCustomer(UUID uuid, CustomerDto customerDto) {
		restTemplate.put(getCustomerUrlFor(uuid), customerDto);
	}

	public void deleteCustomer(UUID uuid) {
		restTemplate.delete(getCustomerUrlFor(uuid));
	}
	
	private String getCustomerUrl() {
		return apihost + CUSTOMER_V1_PATH;
	}
	
	private String getCustomerUrlFor(UUID uuid) {
		return getCustomerUrl() + uuid.toString();
	}
	
}
