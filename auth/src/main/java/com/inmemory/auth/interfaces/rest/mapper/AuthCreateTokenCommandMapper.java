package com.inmemory.auth.interfaces.rest.mapper;

import com.inmemory.auth.common.configuration.MapStructConfig;
import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class AuthCreateTokenCommandMapper {

    public abstract AuthCreateTokenCommand mapToCommand(AuthCreateTokenReqDto authCreateTokenReqDto);
}
