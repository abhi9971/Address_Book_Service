package com.addressbookservice.Address_Book_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookServiceApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to address book ");
		SpringApplication.run(AddressBookServiceApplication.class, args);
	}

}
