package com.inmemory.auth.interfaces.rest.mapper;

import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenRspDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AuthCreateTokenCommandMapperTest {
    private final AuthCreateTokenCommandMapper mapper = Mappers.getMapper(AuthCreateTokenCommandMapper.class);

    @Test
    void mapToCommand() {
        //  given
        AuthCreateTokenReqDto authCreateTokenReqDto = AuthCreateTokenReqDto.builder()
                .userNo("testUserNo")
                .build();

        //  when
        AuthCreateTokenCommand actual = mapper.mapToCommand(authCreateTokenReqDto);

        //  then
        assertAll(
                () -> assertThat(actual.getUserNo()).isEqualTo(authCreateTokenReqDto.userNo())
        );
    }

    @Test
    void mapToRspDto() {
        //  given
        AuthCreateTokenVo authCreateTokenVo = AuthCreateTokenVo.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();

        //  when
        AuthCreateTokenRspDto actual = mapper.mapToRspDto(authCreateTokenVo);

        //  then
        assertAll(
                () -> assertThat(actual.accessToken()).isEqualTo(authCreateTokenVo.accessToken()),
                () -> assertThat(actual.refreshToken()).isEqualTo(authCreateTokenVo.refreshToken())
        );
    }
}