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
    private Boolean error = false;
    private String errorMessage;

    public RetrieveRaffleResponse(List<RaffleDTO> raffles) {
        this.raffles = raffles;
    }
}
