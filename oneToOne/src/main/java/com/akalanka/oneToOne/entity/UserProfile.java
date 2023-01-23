package com.akalanka.oneToOne.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "dob")
    private LocalDate dob;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "userProfile")
    private User user;

    public UserProfile(String phone, String address, Gender gender, LocalDate dob) {
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }
}
