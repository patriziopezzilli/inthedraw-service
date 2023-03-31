package com.inthedraw.inthedrawservice.mapper;

import com.inthedraw.inthedrawservice.entity.user.UserEntity;
import com.inthedraw.inthedrawservice.model.user.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDTO toDTO(UserEntity source);

    UserEntity toEntity(UserDTO destination);

    List<UserDTO> toDTOs(List<UserEntity> source);

    List<UserEntity> toEntities(List<UserDTO> destination);
}
