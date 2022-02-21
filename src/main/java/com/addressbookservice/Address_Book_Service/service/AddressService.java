package com.addressbookservice.Address_Book_Service.service;

import com.addressbookservice.Address_Book_Service.dto.AddressBookDTO;
import com.addressbookservice.Address_Book_Service.model.Address;
import com.addressbookservice.Address_Book_Service.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository repository;

    public String getMessage(String name) {
        return "Welcome " + name;
    }

    public String postMessage(Address address) {
        return "Hello " + address.getFirstName() + " " + address.getLastName();
    }

    public String putMessage(String name) {
        return "How are you, " + name;
    }

    public String getWelcome() {
        return "Welcome to Address Book !";
    }

    public Address saveDataToRepo(AddressBookDTO addressBookDTO) {
        Address newAddress = new Address(addressBookDTO);
        repository.save(newAddress);
        return newAddress;
    }

    public String deleteDataById(Integer id) {
        repository.deleteById(id);
        return "Employee with unique ID:" + id + " got deleted";
    }
}