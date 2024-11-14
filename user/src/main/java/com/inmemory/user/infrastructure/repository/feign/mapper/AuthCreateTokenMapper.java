package com.inmemory.user.infrastructure.repository.feign.mapper;

import com.inmemory.user.common.configuration.MapStructConfig;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.infrastructure.repository.feign.dto.AuthCreateTokenReqDto;
import com.inmemory.user.infrastructure.repository.feign.dto.AuthCreateTokenRspDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class AuthCreateTokenMapper {

    public abstract AuthCreateTokenReqDto mapToReqDto(String userNo);

    public abstract AuthCreateTokenVo mapToVo(AuthCreateTokenRspDto authCreateTokenRspDto);
}
