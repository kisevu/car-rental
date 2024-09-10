package com.ameda.kevin.car_rental.controller;
/*
*
@author ameda
@project car-rental
*
*/

import com.ameda.kevin.car_rental.dto.SignUpRequest;
import com.ameda.kevin.car_rental.dto.UserDto;
import com.ameda.kevin.car_rental.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpCustomer(@RequestBody SignUpRequest request){
        if(authService.hashCustomerWithEmail(request.getEmail())){
            return new ResponseEntity<>("Customer already exists",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdCustomer  = authService.createUser(request);
        if(createdCustomer == null){
            return new ResponseEntity<>("customer was not created.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
}
