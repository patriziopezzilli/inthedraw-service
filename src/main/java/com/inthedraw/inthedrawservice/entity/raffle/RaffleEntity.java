package com.inthedraw.inthedrawservice.entity.raffle;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "RAFFLE")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RaffleEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "INFO")
    private String info;

    @Column(name = "ENTRIES")
    private Integer entries;

    @Column(name = "ENTRIES_MAX")
    private Integer entriesMax;

    @Column(name = "TOKEN_REQUIRED")
    private Integer tokenRequired;

    @Column(name = "WINNER_ID")
    private Long winnerId;

    @Column(name = "WINNER_NAME")
    private String winnerName;

    @Column(name = "FORCED_WINNER_ID")
    private Long forcedWinnerId;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DATE")
    private String date;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

}
