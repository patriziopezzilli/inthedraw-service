package com.inthedraw.inthedrawservice.service;

import com.inthedraw.inthedrawservice.entity.wallet.WalletEntity;
import com.inthedraw.inthedrawservice.mapper.WalletMapper;
import com.inthedraw.inthedrawservice.model.wallet.WalletDTO;
import com.inthedraw.inthedrawservice.model.wallet.WalletTransactionDTO;
import com.inthedraw.inthedrawservice.repository.wallet.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {
    Logger logger = LoggerFactory.getLogger(WalletService.class);

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletMapper walletMapper;

    public WalletDTO retrieve(Long userId) {
        logger.info("> retrieve wallet for user " + userId.toString());
        WalletEntity entity = walletRepository.findByUserId(userId);
        if(entity != null) {
            return walletMapper.toDTO(entity);
        } else {
            WalletEntity newWallet = new WalletEntity();
            newWallet.setUserId(userId);
            newWallet.setBalance(0);
            walletRepository.save(newWallet);
            return walletMapper.toDTO(newWallet);
        }
    }

    public WalletDTO increaseWallet(Long walletId, Integer amount){
        logger.info("> increase wallet " + walletId.toString() + " with token value: " + amount.toString());
        Optional<WalletEntity> entity = walletRepository.findById(walletId);
        if(entity.isPresent()) {
            entity.get().setBalance(entity.get().getBalance() + amount);
            walletRepository.save(entity.get());

            // create transaction TODO
            return walletMapper.toDTO(entity.get());
        } else return null;
    }

    public WalletDTO decreaseWallet(Long userId, Integer amount){
        logger.info("> decrease wallet for user " + userId + " with token value: " + amount.toString());
        WalletEntity entity = walletRepository.findByUserId(userId);
        if(null != entity) {
            entity.setBalance(entity.getBalance() - amount);
            walletRepository.save(entity);

            // create transaction TODO
            return walletMapper.toDTO(entity);
        } else return null;
    }

    private WalletDTO createTransaction(WalletTransactionDTO transactionDTO, Long walletId) {
        return null;
    }
}
