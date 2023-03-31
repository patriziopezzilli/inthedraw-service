package com.inthedraw.inthedrawservice.model.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginRequest implements Serializable {

    private String email;
    private String password;

}
