package com.inthedraw.inthedrawservice.model.raffle;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateRaffleRequest implements Serializable {

    private String title;
    private String photo;
    private String info;
    private Integer entries;
    private Integer entriesMax;
    private Integer tokenRequired;
    private Integer forcedWinnerId;
    private String drawDate;
}
