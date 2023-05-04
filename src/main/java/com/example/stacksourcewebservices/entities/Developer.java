package com.example.stacksourcewebservices.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "developers")
@Data
@NoArgsConstructor
public class Developer extends User {
    public Developer(Long id, String firstName, String lastName, String email, String phone, String password, String role, String description, String image, String bannerImage) {
        super(id, firstName, lastName, email, phone, password, role, description, image, bannerImage);
    }
}
