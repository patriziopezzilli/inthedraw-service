package com.inthedraw.inthedrawservice.entity.wallet;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "WALLET_TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WalletTransactionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "WALLET_ID")
    private Long walletId;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UPDATE_DATE")
    private String date;

    @Column(name = "EXTRA_INFO")
    private String extraInfo;

}
