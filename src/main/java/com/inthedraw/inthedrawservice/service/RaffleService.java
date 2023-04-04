package com.inthedraw.inthedrawservice.service;

import com.inthedraw.inthedrawservice.controller.RaffleController;
import com.inthedraw.inthedrawservice.entity.raffle.EntryEntity;
import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import com.inthedraw.inthedrawservice.mapper.RaffleMapper;
import com.inthedraw.inthedrawservice.model.raffle.CreateRaffleRequest;
import com.inthedraw.inthedrawservice.model.raffle.RaffleDTO;
import com.inthedraw.inthedrawservice.model.raffle.RetrieveRaffleResponse;
import com.inthedraw.inthedrawservice.repository.raffle.RaffleEntryRepository;
import com.inthedraw.inthedrawservice.repository.raffle.RaffleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static com.inthedraw.inthedrawservice.utils.DomainConstants.*;

@Service
public class RaffleService {
    Logger logger = LoggerFactory.getLogger(RaffleService.class);

    @Autowired
    private RaffleRepository repository;

    @Autowired
    private RaffleEntryRepository entryRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private RaffleMapper mapper;

    public RetrieveRaffleResponse retrieveRaffles(Long userId) {
        RetrieveRaffleResponse response = new RetrieveRaffleResponse();
        List<RaffleEntity> raffleEntities = repository.findByStatus(RAFFLE_STATUS_OPEN);
        response.setRaffles(mapper.toDTOs(raffleEntities));

        for (RaffleDTO r : response.getRaffles()) {
            if (null != userId) {
                if (entryRepository.existsByRaffleIdAndUserId(r.getId(), userId)) {
                    r.setParticipate(true);
                } else {
                    r.setParticipate(false);
                }
            } else {
                r.setParticipate(false);
            }
        }

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

    public RetrieveRaffleResponse joinRaffle(Long raffleId, Long userId) throws ParseException {
        RetrieveRaffleResponse response = new RetrieveRaffleResponse();

        // create entry
        Optional<RaffleEntity> raffleEntity = repository.findById(raffleId);
        if (raffleEntity.isPresent()) {
            // create entry
            EntryEntity entryEntity = new EntryEntity();
            entryEntity.setRaffleId(raffleId);
            entryEntity.setUserId(userId);
            entryEntity.setInfo(raffleEntity.get().getInfo());
            entryEntity.setPhoto(raffleEntity.get().getPhoto());
            entryEntity.setDate(getSimpleTodayDate());
            entryEntity.setStatus(RAFFLE_STATUS_OPEN);
            entryEntity.setTitle(raffleEntity.get().getTitle());
            entryRepository.save(entryEntity);

            // update raffle
            raffleEntity.get().setEntries(raffleEntity.get().getEntries() + 1);
            repository.save(raffleEntity.get());

            // decrease wallet
            walletService.decreaseWallet(userId, raffleEntity.get().getTokenRequired());

            // generate list
            response = retrieveRaffles(userId);
        }
        return response;
    }
}
