package com.inthedraw.inthedrawservice.entity.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "ENTRIES")
    private Integer entries;

    @Column(name = "ENTRIES_WON")
    private Integer entriesWon;
}
