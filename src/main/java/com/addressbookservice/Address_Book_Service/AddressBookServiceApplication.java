package com.addressbookservice.Address_Book_Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AddressBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookServiceApplication.class, args);
		log.info("AddressBook service app started..! ");
	}
}
