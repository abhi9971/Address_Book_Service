package com.addressbookservice.Address_Book_Service.service;

import com.addressbookservice.Address_Book_Service.dto.AddressBookDTO;
import com.addressbookservice.Address_Book_Service.model.Address;

public interface IAddressBookService {
    public String getMessage(String name);

    public String postMessage(Address address);

    public String putMessage(String name);

    public String getWelcome();

    public Address saveDataToRepo(AddressBookDTO addressBookDTO);

    public String deleteDataById(Integer id);

}