package com.inemory.user.infrastructure.feign.mapper;

import com.inemory.user.common.configuration.MapStructConfig;
import com.inemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class AuthCreateTokenVoMapper {

    public abstract AuthCreateTokenVo mapToVo(AuthCreateTokenRspDto authCreateTokenRspDto);
}
