package com.inthedraw.inthedrawservice.model.raffle;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EntryDTO implements Serializable {

    private Long id;
    private Long userId;
    private Long raffleId;
    private String title;
    private String date;
    private String status;
    private Long orderId;
    private String photo;
    private String info;
}
