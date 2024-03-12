package com.inemory.user.interfaces.rest.mapper;

import com.inemory.user.common.configuration.MapStructConfig;
import com.inemory.user.domain.model.command.UserLoginCommand;
import com.inemory.user.interfaces.rest.dto.UserLoginReqDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class UserLoginCommandMapper {

    public abstract UserLoginCommand dtoToCommand(UserLoginReqDto userLoginReqDto);
}
