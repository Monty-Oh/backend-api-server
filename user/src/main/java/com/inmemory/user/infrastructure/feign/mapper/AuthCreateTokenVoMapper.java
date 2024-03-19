package com.inmemory.user.infrastructure.feign.mapper;

import com.inmemory.user.common.configuration.MapStructConfig;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class AuthCreateTokenVoMapper {

    public abstract AuthCreateTokenVo mapToVo(AuthCreateTokenRspDto authCreateTokenRspDto);
}
