package com.inthedraw.inthedrawservice.controller;

import com.inthedraw.inthedrawservice.model.raffle.CreateRaffleRequest;
import com.inthedraw.inthedrawservice.model.raffle.RetrieveRaffleResponse;
import com.inthedraw.inthedrawservice.service.RaffleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class RaffleController {
    Logger logger = LoggerFactory.getLogger(RaffleController.class);

    @Autowired
    private RaffleService raffleService;

    @RequestMapping(value = "in-the-draw/customer/raffle", method = RequestMethod.GET)
    public RetrieveRaffleResponse retrieveRaffle(@RequestParam(required = false) Long userId) {
        logger.info("> retrieve raffle");
        return raffleService.retrieveRaffles(userId);
    }

    @RequestMapping(value = "in-the-draw/customer/raffle/entries", method = RequestMethod.GET)
    public RetrieveRaffleResponse retrieveRaffleEntries(@RequestParam(required = false) Long userId) {
        logger.info("> retrieve raffle entries");
        return raffleService.retrieveRaffleEntries(userId);
    }

    @RequestMapping(value = "in-the-draw/customer/raffle", method = RequestMethod.POST)
    public void createRaffle(@RequestBody CreateRaffleRequest request) throws ParseException {
        logger.info("> create raffle");
        raffleService.createRaffle(request);
    }

    @RequestMapping(value = "in-the-draw/customer/raffle/{id}/join", method = RequestMethod.PUT)
    public RetrieveRaffleResponse join(@PathVariable Long id, @RequestParam Long userId) throws ParseException {
        logger.info("> join raffle");
        return raffleService.joinRaffle(id, userId);
    }

    @RequestMapping(value = "in-the-draw/customer/raffle/{id}/join/fake", method = RequestMethod.PUT)
    public void fakeJoin(@PathVariable Long id, @RequestParam Integer entries) throws ParseException {
        logger.info("> join raffle");
        raffleService.fakeFill(id, entries);
    }

    @RequestMapping(value = "in-the-draw/customer/raffle/{id}/draw", method = RequestMethod.PUT)
    public void draw(@PathVariable Long id) throws ParseException {
        logger.info("> draw raffle");
        raffleService.draw(id);
    }

    @RequestMapping(value = "in-the-draw/customer/raffle/{id}/cancel", method = RequestMethod.PUT)
    public RetrieveRaffleResponse cancel(@PathVariable Long id, @RequestParam Long userId) throws ParseException {
        logger.info("> cancel raffle");
        return raffleService.cancelRaffle(id, userId);
    }
}
