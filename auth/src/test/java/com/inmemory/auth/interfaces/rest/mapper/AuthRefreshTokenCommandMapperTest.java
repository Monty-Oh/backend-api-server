package com.inmemory.auth.interfaces.rest.mapper;

import com.inmemory.auth.domain.model.command.AuthRefreshTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthRefreshTokenVo;
import com.inmemory.auth.interfaces.rest.dto.AuthRefreshTokenRspDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AuthRefreshTokenCommandMapperTest {
    private final AuthRefreshTokenCommandMapper mapper = Mappers.getMapper(AuthRefreshTokenCommandMapper.class);

    @Test
    void mapToCommand() {
        //  given
        String refreshToken = "testRefreshToken";

        //  when
        AuthRefreshTokenCommand actual = mapper.mapToCommand(refreshToken);

        //  then
        assertAll(
                () -> assertThat(actual.getRefreshToken()).isEqualTo(refreshToken)
        );
    }

    @Test
    void mapToRspDto() {
        //  given
        AuthRefreshTokenVo authRefreshTokenVo = AuthRefreshTokenVo.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();

        //  when
        AuthRefreshTokenRspDto actual = mapper.mapToRspDto(authRefreshTokenVo);

        //  then
        assertAll(
                () -> assertThat(actual.accessToken()).isEqualTo(authRefreshTokenVo.accessToken()),
                () -> assertThat(actual.refreshToken()).isEqualTo(authRefreshTokenVo.refreshToken())
        );
    }
}