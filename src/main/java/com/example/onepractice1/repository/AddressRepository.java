package com.example.onepractice1.repository;

import com.example.onepractice1.models.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> findAll();
    Address findAddressById(Long id);
    void saveAddress(Address address);
    boolean deleteAddressById(Long id);
}
