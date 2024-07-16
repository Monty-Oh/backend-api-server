package com.inmemory.auth.interfaces.rest.mapper;

import com.inmemory.auth.common.configuration.MapStructConfig;
import com.inmemory.auth.domain.model.command.AuthRefreshTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthRefreshTokenVo;
import com.inmemory.auth.interfaces.rest.dto.AuthRefreshTokenRspDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class AuthRefreshTokenCommandMapper {

    public abstract AuthRefreshTokenCommand mapToCommand(String refreshToken);

    public abstract AuthRefreshTokenRspDto mapToRspDto(AuthRefreshTokenVo authRefreshTokenVo);
}
