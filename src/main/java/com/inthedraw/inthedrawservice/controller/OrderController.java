package com.inthedraw.inthedrawservice.controller;


import com.inthedraw.inthedrawservice.model.order.OrderDTO;
import com.inthedraw.inthedrawservice.model.raffle.RetrieveRaffleResponse;
import com.inthedraw.inthedrawservice.model.user.UserDTO;
import com.inthedraw.inthedrawservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "in-the-draw/customer/order/{id}", method = RequestMethod.GET)
    public OrderDTO retrieveOrder(@PathVariable Long id) {
        logger.info("> retrieve order " + id.toString());
        return orderService.retrieveOrder(id);
    }
}
