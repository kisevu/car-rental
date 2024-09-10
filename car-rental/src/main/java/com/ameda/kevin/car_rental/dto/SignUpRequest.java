package com.ameda.kevin.car_rental.dto;
/*
*
@author ameda
@project car-rental
*
*/

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String name;
    private String password;
}
