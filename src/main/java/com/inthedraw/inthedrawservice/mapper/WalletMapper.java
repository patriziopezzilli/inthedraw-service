package com.inthedraw.inthedrawservice.mapper;

import com.inthedraw.inthedrawservice.entity.user.UserEntity;
import com.inthedraw.inthedrawservice.entity.wallet.WalletEntity;
import com.inthedraw.inthedrawservice.model.user.UserDTO;
import com.inthedraw.inthedrawservice.model.wallet.WalletDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WalletMapper {

    WalletDTO toDTO(WalletEntity source);

    WalletEntity toEntity(WalletDTO destination);

}
