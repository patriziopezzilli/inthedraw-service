package com.inthedraw.inthedrawservice.model.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateUserRequest implements Serializable {

    private String name;
    private String surname;
    private String size;
    private String photo;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String description;

}
