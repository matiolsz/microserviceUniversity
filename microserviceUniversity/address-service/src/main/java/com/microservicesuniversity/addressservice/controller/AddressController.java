package com.microservicesuniversity.addressservice.controller;

import com.microservicesuniversity.addressservice.request.CreateAddressRequest;
import com.microservicesuniversity.addressservice.response.AddressResponse;
import com.microservicesuniversity.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id) {
        return addressService.getById(id);
    }
}
