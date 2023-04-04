package com.inthedraw.inthedrawservice.repository.wallet;

import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import com.inthedraw.inthedrawservice.entity.wallet.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    WalletEntity findByUserId(Long userId);
}
