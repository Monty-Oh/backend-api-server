package com.inmemory.user.infrastructure.repository.feign.mapper;

import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.infrastructure.repository.feign.dto.AuthCreateTokenReqDto;
import com.inmemory.user.infrastructure.repository.feign.dto.AuthCreateTokenRspDto;
import com.inmemory.user.infrastructure.repository.feign.mapper.AuthCreateTokenMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AuthCreateTokenMapperTest {
    private final AuthCreateTokenMapper mapper = Mappers.getMapper(AuthCreateTokenMapper.class);

    @Test
    void mapToReqDto() {
        //  given
        String userNo = "testUserNo";

        //  when
        AuthCreateTokenReqDto actual = mapper.mapToReqDto(userNo);

        //  then
        assertThat(actual.userNo()).isEqualTo(userNo);
    }

    @Test
    void mapToVo() {
        //  given
        AuthCreateTokenRspDto authCreateTokenRspDto = AuthCreateTokenRspDto.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();

        //  when
        AuthCreateTokenVo actual = mapper.mapToVo(authCreateTokenRspDto);

        //  then
        assertAll(
                () -> assertThat(actual.accessToken()).isEqualTo(authCreateTokenRspDto.accessToken()),
                () -> assertThat(actual.refreshToken()).isEqualTo(authCreateTokenRspDto.refreshToken())
        );
    }
}