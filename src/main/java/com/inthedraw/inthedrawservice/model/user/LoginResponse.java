package com.inthedraw.inthedrawservice.model.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginResponse implements Serializable {

    private UserDTO userLogged;

    private Boolean error = false;
    private String errorMessage;

}
