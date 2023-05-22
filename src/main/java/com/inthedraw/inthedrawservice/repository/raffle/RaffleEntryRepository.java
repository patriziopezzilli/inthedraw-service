package com.inthedraw.inthedrawservice.repository.raffle;

import com.inthedraw.inthedrawservice.entity.raffle.EntryEntity;
import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaffleEntryRepository extends JpaRepository<EntryEntity, Long> {

    boolean existsByRaffleIdAndUserId(Long raffleId, Long userId);

    EntryEntity findByRaffleIdAndUserId(Long raffleId, Long userId);

    List<EntryEntity> findByRaffleId(Long raffleId);
}
