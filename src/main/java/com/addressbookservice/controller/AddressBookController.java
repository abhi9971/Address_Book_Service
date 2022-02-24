package com.addressbookservice.controller;

import com.addressbookservice.dto.AddressBookDTO;
import com.addressbookservice.dto.ResponseDTO;
import com.addressbookservice.exception.AddressBookException;
import com.addressbookservice.model.Address;
import com.addressbookservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")

public class AddressBookController {
    @Autowired
    AddressService service;

    //Ability to store a address book record to repository
    @PostMapping("/create")
    public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        Address newAddress = service.saveDataToRepo(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record created successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    //Ability to get address book record to repository
    @GetMapping("/get")
    public ResponseEntity<String> getDataFromRepo() {
        List<Address> newAddress = service.getRecord();
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    //Ability to get address book record by id
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getRecordFromRepoByID(@PathVariable Integer id) throws AddressBookException {
        Address newAddress = service.getRecordById(id);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }


    //Ability to update address book record to repository
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRecordById(@PathVariable Integer id, @Valid @RequestBody AddressBookDTO addressBookDTO) throws AddressBookException {
        Address newAddress = service.updateRecordById(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record updated successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    //Ability to delete address book record to repository
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecordById(@PathVariable Integer id) throws AddressBookException {
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully", service.deleteRecordById(id));
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}
