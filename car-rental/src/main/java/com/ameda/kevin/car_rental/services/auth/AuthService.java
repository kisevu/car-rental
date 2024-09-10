package com.ameda.kevin.car_rental.services.auth;
/*
*
@author ameda
@project car-rental
*
*/

import com.ameda.kevin.car_rental.dto.SignUpRequest;
import com.ameda.kevin.car_rental.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignUpRequest request);
    boolean hashCustomerWithEmail(String email);
}
