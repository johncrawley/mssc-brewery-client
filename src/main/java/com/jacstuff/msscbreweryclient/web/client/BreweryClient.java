package com.jacstuff.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jacstuff.msscbreweryclient.web.model.BeerDto;

@Component
@ConfigurationProperties("sfg.brewery")
public class BreweryClient {

	public String apihost;
	public final String BEER_PATH_V1 = "/api/v1/beer/"; // in theory should never change, so don't make it a property;
	private final RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(getUrlFor(uuid), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(getUrl(), beerDto);
	}
	

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(getUrlFor(uuid), beerDto);	
	}
	
	public void deleteBeer(UUID uuid) {
		restTemplate.delete(getUrlFor(uuid));
	}
	
	
	public void setApiHost(String apihost) {
		this.apihost = apihost;
	}
	

	private String getUrl() {
		return apihost + BEER_PATH_V1;
	}
	
	private String getUrlFor(UUID uuid) {
		return getUrl() + uuid.toString();
	}
}
