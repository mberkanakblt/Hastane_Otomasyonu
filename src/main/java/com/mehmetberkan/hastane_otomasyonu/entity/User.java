package com.mehmetberkan.hastane_otomasyonu.entity;

import com.mehmetberkan.hastane_otomasyonu.utility.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String surname;
    @Column(nullable = false,unique = true)
    String email;
    @Column(nullable = false)
    String password;
    String repassword;
    @Column(nullable = false,unique = true)
    String phone;
    @Column(nullable = false)
    String address;
    @Column(nullable = false,unique = true)
    String tckn;
    @Column(nullable = false)
    String age;
    @Column(nullable = false)
    Gender gender;
}
