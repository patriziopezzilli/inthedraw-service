package com.inthedraw.inthedrawservice.service;

import com.inthedraw.inthedrawservice.controller.RaffleController;
import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import com.inthedraw.inthedrawservice.mapper.RaffleMapper;
import com.inthedraw.inthedrawservice.model.raffle.CreateRaffleRequest;
import com.inthedraw.inthedrawservice.model.raffle.RetrieveRaffleResponse;
import com.inthedraw.inthedrawservice.repository.raffle.RaffleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

import static com.inthedraw.inthedrawservice.utils.DomainConstants.RAFFLE_STATUS_OPEN;
import static com.inthedraw.inthedrawservice.utils.DomainConstants.getTodayDate;

@Service
public class RaffleService {
    Logger logger = LoggerFactory.getLogger(RaffleService.class);

    @Autowired
    private RaffleRepository repository;

    @Autowired
    private RaffleMapper mapper;

    public RetrieveRaffleResponse retrieveRaffles() {
        RetrieveRaffleResponse response = new RetrieveRaffleResponse();
        List<RaffleEntity> raffleEntities = repository.findAll();
        response.setRaffles(mapper.toDTOs(raffleEntities));
        return response;
    }

    public void createRaffle(CreateRaffleRequest request) throws ParseException {
        RaffleEntity entity = new RaffleEntity();
        entity.setTitle(request.getTitle());
        entity.setPhoto(request.getPhoto());
        entity.setInfo(request.getInfo());
        entity.setEntries(0);
        entity.setEntriesMax(request.getEntriesMax());
        entity.setTokenRequired(request.getTokenRequired());
        entity.setForcedWinnerId(request.getForcedWinnerId());
        entity.setStatus(RAFFLE_STATUS_OPEN);
        entity.setDate(getTodayDate(request.getDrawDate()));
        entity = repository.save(entity);
        logger.info("> raffle " + entity.getId().toString() + " created successfully");
    }
}
