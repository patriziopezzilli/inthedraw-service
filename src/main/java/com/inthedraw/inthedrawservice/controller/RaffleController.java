package com.inthedraw.inthedrawservice.controller;

import com.inthedraw.inthedrawservice.model.raffle.CreateRaffleRequest;
import com.inthedraw.inthedrawservice.model.raffle.RetrieveRaffleResponse;
import com.inthedraw.inthedrawservice.service.RaffleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class RaffleController {
    Logger logger = LoggerFactory.getLogger(RaffleController.class);

    @Autowired
    private RaffleService raffleService;

    @RequestMapping(value = "in-the-draw/customer/raffle", method = RequestMethod.GET)
    public RetrieveRaffleResponse retrieveRaffle() {
        logger.info("> retrieve raffle");
        return raffleService.retrieveRaffles();
    }

    @RequestMapping(value = "in-the-draw/customer/raffle", method = RequestMethod.POST)
    public void createRaffle(@RequestBody CreateRaffleRequest request) throws ParseException {
        logger.info("> create raffle");
        raffleService.createRaffle(request);
    }
}
