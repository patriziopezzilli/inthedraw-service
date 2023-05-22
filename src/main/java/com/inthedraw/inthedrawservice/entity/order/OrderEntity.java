package com.inthedraw.inthedrawservice.entity.order;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "RAFFLE_ID")
    private Long raffleId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "CONFIRMED")
    private Boolean confirmed;

    @Column(name = "TRACKING")
    private String tracking;
}
