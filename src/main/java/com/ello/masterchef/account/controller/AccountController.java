package com.ello.masterchef.account.controller;

import com.ello.masterchef.account.model.CustomerAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/account")
public class AccountController {

    @PostMapping(value = "/customer")
    public ResponseEntity<?> createCustomerAccount(@RequestBody CustomerAccount customerAccount) {
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
