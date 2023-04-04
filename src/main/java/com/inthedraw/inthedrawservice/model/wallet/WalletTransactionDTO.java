package com.inthedraw.inthedrawservice.model.wallet;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WalletTransactionDTO {

    private Integer amount;
    private String description;
    private String date;
    private String extraInfo;
}
