package com.jacstuff.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jacstuff.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {

	public BreweryClientTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private BreweryClient client;

	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void saveNewBeer() {
		String beerName = "new beer";
		BeerDto beerDto = BeerDto.builder().beerName(beerName).build();
		URI uri = client.saveNewBeer(beerDto);
		assertNotNull(uri);

		System.out.println("Saved beer URI:  " +  uri);
	}
	
}
