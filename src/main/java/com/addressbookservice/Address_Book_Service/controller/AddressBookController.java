package com.addressbookservice.Address_Book_Service.controller;

import com.addressbookservice.Address_Book_Service.model.Address;
import com.addressbookservice.Address_Book_Service.service.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")

public class AddressBookController {
    @Autowired
    AddressServices service;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name) {
        String message = service.getMessage(name);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PostMapping("/postMessage")
    public ResponseEntity<String> postMessage(@RequestBody Address address) {
        String message = service.postMessage(address);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PutMapping("/putMessage/{name}")
    public ResponseEntity<String> putMessage(@PathVariable String name) {
        String message = service.putMessage(name);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
