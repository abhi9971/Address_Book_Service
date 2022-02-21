package com.addressbookservice.Address_Book_Service.controller;

import com.addressbookservice.Address_Book_Service.dto.AddressBookDTO;
import com.addressbookservice.Address_Book_Service.dto.ResponseDTO;
import com.addressbookservice.Address_Book_Service.model.Address;
import com.addressbookservice.Address_Book_Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")

public class AddressBookController {
    @Autowired
    AddressService service;

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

    //Ability to get a welcome message
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        String message = service.getWelcome();
        return new ResponseEntity(message, HttpStatus.OK);
    }

    //Ability of storing addressbook in repository
    @PostMapping("/create")
    public ResponseEntity<String> saveDataToRepo(@RequestBody AddressBookDTO addressBookDTO) {
        Address newAddress = service.saveDataToRepo(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book created successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    //Ability to delete employee data for particular id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}
