package com.inthedraw.inthedrawservice.mapper;

import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import com.inthedraw.inthedrawservice.model.raffle.RaffleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RaffleMapper {

    RaffleDTO toDTO(RaffleEntity source);
    RaffleEntity toEntity(RaffleDTO destination);
    List<RaffleDTO> toDTOs(List<RaffleEntity> source);
    List<RaffleEntity> toEntities(List<RaffleDTO> destination);
}
