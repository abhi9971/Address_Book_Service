package com.addressbookservice.Address_Book_Service.repository;

import com.addressbookservice.Address_Book_Service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
