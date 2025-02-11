package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Address;

import java.util.UUID;

public record AddressDTO(UUID id, String street, String number, String complement, String district,
                         String city, String state, String cep) {
    public AddressDTO(Address address){
        this(address.getId(), address.getStreet(), address.getNumber(), address.getComplement(), address.getDistrict(), address.getCity(), address.getState(),
                address.getCep());
    }
}
