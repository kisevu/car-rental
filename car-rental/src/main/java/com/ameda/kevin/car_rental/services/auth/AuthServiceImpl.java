package com.ameda.kevin.car_rental.services.auth;
/*
*
@author ameda
@project car-rental
*
*/

import com.ameda.kevin.car_rental.dto.SignUpRequest;
import com.ameda.kevin.car_rental.dto.UserDto;
import com.ameda.kevin.car_rental.entity.User;
import com.ameda.kevin.car_rental.enums.UserRole;
import com.ameda.kevin.car_rental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(SignUpRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto dto = new UserDto();
        dto.setId(createdUser.getId());
        return dto;
    }

    @Override
    public boolean hashCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
