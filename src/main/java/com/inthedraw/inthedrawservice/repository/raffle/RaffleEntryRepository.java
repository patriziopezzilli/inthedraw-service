package com.inthedraw.inthedrawservice.repository.raffle;

import com.inthedraw.inthedrawservice.entity.raffle.EntryEntity;
import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleEntryRepository extends JpaRepository<EntryEntity, Long> {

    boolean existsByRaffleIdAndUserId(Long raffleId, Long userId);
}
