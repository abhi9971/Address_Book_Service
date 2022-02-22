package com.addressbookservice.service;

import com.addressbookservice.dto.AddressBookDTO;
import com.addressbookservice.exception.AddressBookException;
import com.addressbookservice.model.Address;
import com.addressbookservice.repository.AddressRepository;
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
        List<Address> addressList = repository.findAll();
        Address newAddress = addressList.stream().filter(addressData -> addressData.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Specific address book details not found"));
        return newAddress;
    }

    public List<Address> getRecord() {
        return repository.findAll();
    }


    public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
        List<Address> addressList = repository.findAll();
        Address newAddress = addressList.stream().filter(addressData -> addressData.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Specific address book details not found"));
        Address newAddressBook = new Address(id, addressBookDTO);
        repository.save(newAddressBook);
        return newAddressBook;
    }

    public String deleteRecordById(Integer id) {
        List<Address> addressList = repository.findAll();
        Address newAddress = addressList.stream().filter(addressData -> addressData.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Specific address book details not found"));
        repository.delete(newAddress);
        return null;
    }

}