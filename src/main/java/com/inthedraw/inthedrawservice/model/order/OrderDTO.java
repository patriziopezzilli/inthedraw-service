package com.inthedraw.inthedrawservice.model.order;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDTO implements Serializable {

    private Long id;
    private Long userId;
    private Long raffleId;
    private String status;
    private String address;
    private String email;
    private String name;
    private String surname;
    private Boolean confirmed;
    private String tracking;
}
