package com.inthedraw.inthedrawservice.model.raffle;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RaffleDTO implements Serializable {

    private Long id;
    private String title;
    private String info;
    private String photo;
    private Integer entries;
    private Integer entriesMax;
    private Integer tokenRequired;
    private Integer winnerId;
    private String winnerName;
    private Integer forcedWinnerId;
    private Integer orderId;
    private String status;
    private String date;
    private Boolean participate;

}
