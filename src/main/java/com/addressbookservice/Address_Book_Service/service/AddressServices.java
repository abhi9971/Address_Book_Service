package com.addressbookservice.Address_Book_Service.service;

import com.addressbookservice.Address_Book_Service.model.Address;

public class AddressServices {
    public String getMessage(String name) {
        return "Welcome " + name;
    }

    public String postMessage(Address address) {
        return "Hello " + address.getFirstName() + " " + address.getLastName();
    }

    public String putMessage(String name) {
        return "How are you, " + name;
    }
}