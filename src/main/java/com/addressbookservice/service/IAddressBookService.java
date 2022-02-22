package com.addressbookservice.service;

import com.addressbookservice.dto.AddressBookDTO;
import com.addressbookservice.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    public String getMessage(String name);

    public String postMessage(Address address);

    public String putMessage(String name);

    public String getWelcome();

    public Address saveDataToRepo(AddressBookDTO addressBookDTO);

    public Optional<Address> getRecordById(Integer id);

    public List<Address> getRecord();


    public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO);

    public String deleteRecordById(Integer id);
}