package com.inthedraw.inthedrawservice.repository.raffle;

import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaffleRepository extends JpaRepository<RaffleEntity, Long> {

    List<RaffleEntity> findByStatusOrderByReleaseDateAsc(String status);
}
