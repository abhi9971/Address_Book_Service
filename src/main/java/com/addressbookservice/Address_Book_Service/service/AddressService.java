package com.addressbookservice.Address_Book_Service.service;

import com.addressbookservice.Address_Book_Service.dto.AddressBookDTO;
import com.addressbookservice.Address_Book_Service.model.Address;
import com.addressbookservice.Address_Book_Service.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Address getRecordById(Integer id) {
        Address address = repository.getById(id);
        return address;
    }

    public List<Address> getRecord() {
        return repository.findAll();
    }

    public List<Address> getRecordByFirstName(String firstName) {
        List<Address> list = repository.findByFirstName(firstName);
        return list;
    }

    public List<Address> getRecordByName() {
        return repository.findAllData();
    }

    public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
        Address newBook = new Address(id, addressBookDTO);
        repository.save(newBook);
        return newBook;
    }

    public String deleteRecordById(Integer id) {
        repository.deleteById(id);
        return null;
    }

}