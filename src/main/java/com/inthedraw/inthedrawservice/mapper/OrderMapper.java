package com.inthedraw.inthedrawservice.mapper;

import com.inthedraw.inthedrawservice.entity.order.OrderEntity;
import com.inthedraw.inthedrawservice.entity.raffle.EntryEntity;
import com.inthedraw.inthedrawservice.model.order.OrderDTO;
import com.inthedraw.inthedrawservice.model.raffle.EntryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderDTO toDTO(OrderEntity source);

    OrderEntity toEntity(OrderDTO destination);
}
