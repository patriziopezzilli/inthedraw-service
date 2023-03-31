package com.inthedraw.inthedrawservice.repository.raffle;

import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository<RaffleEntity, Integer> {
}
