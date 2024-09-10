package com.ameda.kevin.car_rental.dto;
/*
*
@author ameda
@project car-rental
*
*/

import com.ameda.kevin.car_rental.enums.UserRole;
import lombok.Data;

@Data

public class UserDto {

    private Long id;
    private String name;
    private String email;
    private UserRole userRole;

}
