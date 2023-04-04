package com.inthedraw.inthedrawservice.repository.wallet;

import com.inthedraw.inthedrawservice.entity.wallet.WalletEntity;
import com.inthedraw.inthedrawservice.entity.wallet.WalletTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransactionEntity, Long> {
}
