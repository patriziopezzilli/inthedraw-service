package com.inthedraw.inthedrawservice.model.raffle;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RetrieveRaffleResponse implements Serializable {

    public List<RaffleDTO> raffles;

    public RetrieveRaffleResponse(List<RaffleDTO> raffles) {
        this.raffles = raffles;
    }
}
