package com.inthedraw.inthedrawservice.entity.raffle;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RAFFLE_ENTRY")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EntryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "RAFFLE_ID")
    private Long raffleId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private String date;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "INFO")
    private String info;
}
