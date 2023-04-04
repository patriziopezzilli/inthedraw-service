package com.inthedraw.inthedrawservice.entity.wallet;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "WALLET")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WalletEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "BALANCE")
    private Integer balance;
}
