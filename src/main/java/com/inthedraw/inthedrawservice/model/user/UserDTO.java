package com.inthedraw.inthedrawservice.model.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String size;
    private String photo;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String description;
    private String status;
    private String role;
    private Integer entries;
    private Integer entriesWon;
}
