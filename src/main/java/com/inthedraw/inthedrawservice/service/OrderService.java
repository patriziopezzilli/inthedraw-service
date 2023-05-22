package com.inthedraw.inthedrawservice.service;

import com.inthedraw.inthedrawservice.entity.order.OrderEntity;
import com.inthedraw.inthedrawservice.mapper.OrderMapper;
import com.inthedraw.inthedrawservice.model.order.OrderDTO;
import com.inthedraw.inthedrawservice.repository.order.OrderRepository;
import com.inthedraw.inthedrawservice.repository.raffle.RaffleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderMapper mapper;

    public OrderDTO retrieveOrder(Long orderId){
        Optional<OrderEntity> order = repository.findById(orderId);
        return order.map(orderEntity -> mapper.toDTO(orderEntity)).orElse(null);
    }
}
