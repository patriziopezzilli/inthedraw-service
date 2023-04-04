package com.inthedraw.inthedrawservice.mapper;

import com.inthedraw.inthedrawservice.entity.raffle.EntryEntity;
import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import com.inthedraw.inthedrawservice.model.raffle.EntryDTO;
import com.inthedraw.inthedrawservice.model.raffle.RaffleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EntryMapper {

    EntryDTO toDTO(EntryEntity source);

    EntryEntity toEntity(EntryDTO destination);
}
