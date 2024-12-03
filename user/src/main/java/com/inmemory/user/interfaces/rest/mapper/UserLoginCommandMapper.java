package com.inmemory.user.interfaces.rest.mapper;

import com.inmemory.user.common.configuration.MapStructConfig;
import com.inmemory.user.domain.model.command.UserLoginCommand;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.interfaces.rest.dto.UserLoginReqDto;
import com.inmemory.user.interfaces.rest.dto.UserLoginRspDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class UserLoginCommandMapper {

    public abstract UserLoginCommand mapToCommand(UserLoginReqDto userLoginReqDto);

    public abstract UserLoginRspDto mapToRspDto(AuthCreateTokenVo authCreateTokenVo);
}
