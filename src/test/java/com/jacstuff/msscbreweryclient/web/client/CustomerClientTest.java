package com.jacstuff.msscbreweryclient.web.client;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jacstuff.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
public class CustomerClientTest {

	public CustomerClientTest() {
		// TODO Auto-generated constructor stub
	}

	@Autowired CustomerClient customerClient;
	
	
	@Test
	public void getCustomer() {
		
	}
	
	@Test
	public void addCustomer() {
		CustomerDto customerDto = new CustomerDto();
		customerClient.addNewCustomer(customerDto);
	}
	
	
	@Test
	public void updateCustomer() {
		CustomerDto customerDto = new CustomerDto();
		UUID uuid = UUID.randomUUID();
		customerClient.updateCustomer(uuid, customerDto);
	}
	
	
	@Test
	public void deleteCustomer() {
		UUID uuid = UUID.randomUUID();
		customerClient.deleteCustomer(uuid);
		
	}
	
	
	
}
