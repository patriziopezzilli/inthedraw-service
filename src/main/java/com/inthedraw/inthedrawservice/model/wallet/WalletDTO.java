package com.inthedraw.inthedrawservice.model.wallet;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WalletDTO {

    private Long id;
    private Integer balance;
   // private List<WalletTransactionDTO> transactions;

}
