package com.inthedraw.inthedrawservice.repository.order;

import com.inthedraw.inthedrawservice.entity.order.OrderEntity;
import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
