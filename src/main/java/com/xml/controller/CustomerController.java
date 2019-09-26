package com.xml.controller;

import java.io.IOException;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.xml.model.Customer;

@RestController
public class CustomerController {

	private ObjectMapper mapper = new XmlMapper();

	private final ResourceLoader resourceLoader;

	CustomerController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@GetMapping(value = "/customer", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Customer> product() throws IOException {
		Customer cust = mapper.readValue(resourceLoader.getResource("classpath:customer.xml")
						.getFile(),Customer.class);
		return ResponseEntity.ok(cust);
	}
}
