package com.inthedraw.inthedrawservice.controller;

import com.inthedraw.inthedrawservice.model.wallet.WalletDTO;
import com.inthedraw.inthedrawservice.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    Logger logger = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "in-the-draw/customer/wallet/user/{id}", method = RequestMethod.GET)
    public WalletDTO retrieveWallet(@PathVariable Integer id) {
        logger.info("> retrieve wallet for user " + id.toString());
        return walletService.retrieve(id.longValue());
    }

    @RequestMapping(value = "in-the-draw/customer/wallet/{id}", method = RequestMethod.PUT)
    public WalletDTO increase(@PathVariable Integer id, @RequestParam Integer amount) {
        logger.info("> increase wallet " + id.toString());
        return walletService.increaseWallet(id.longValue(), amount);
    }
}
