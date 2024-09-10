package com.ameda.kevin.car_rental.entity;

import com.ameda.kevin.car_rental.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

/*
*
@author ameda
@project car-rental
*
*/
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
