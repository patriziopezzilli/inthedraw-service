package com.inthedraw.inthedrawservice.model.user;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateUserRequest implements Serializable {

    private String name;
    private String surname;
    private String email;
    private String password;

}
