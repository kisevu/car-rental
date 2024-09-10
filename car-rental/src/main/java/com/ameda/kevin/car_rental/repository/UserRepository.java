package com.ameda.kevin.car_rental.repository;
/*
*
@author ameda
@project car-rental
*
*/

import com.ameda.kevin.car_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByEmail(String email);
}
