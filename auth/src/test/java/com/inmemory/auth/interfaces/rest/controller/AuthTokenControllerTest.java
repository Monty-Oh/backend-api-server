package com.inmemory.auth.interfaces.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmemory.auth.application.commandservice.AuthTokenCommandService;
import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.interfaces.rest.constants.AuthApiUrl;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenRspDto;
import com.inmemory.auth.interfaces.rest.mapper.AuthCreateTokenCommandMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthTokenController.class)
class AuthTokenControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthTokenCommandService authTokenCommandService;

    @MockBean
    private AuthCreateTokenCommandMapper authCreateTokenCommandMapper;

    @Test
    @DisplayName("토큰 생성 요청을 했고 성공 응답이 왔다.")
    void createToken_success() throws Exception {
        //  given
        AuthCreateTokenReqDto authCreateTokenReqDto = AuthCreateTokenReqDto.builder()
                .userNo("testUserNo")
                .build();
        AuthCreateTokenCommand authCreateTokenCommand = AuthCreateTokenCommand.builder()
                .userNo(authCreateTokenReqDto.getUserNo())
                .build();
        given(authCreateTokenCommandMapper.mapToCommand(any())).willReturn(authCreateTokenCommand);

        AuthCreateTokenVo authCreateTokenVo = AuthCreateTokenVo.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();
        given(authTokenCommandService.createToken(any())).willReturn(authCreateTokenVo);

        AuthCreateTokenRspDto authCreateTokenRspDto = AuthCreateTokenRspDto.builder()
                .accessToken(authCreateTokenVo.getAccessToken())
                .refreshToken(authCreateTokenVo.getRefreshToken())
                .build();
        given(authCreateTokenCommandMapper.mapToRspDto(any())).willReturn(authCreateTokenRspDto);

        //  when,   then
        mockMvc.perform(
                        MockMvcRequestBuilders.post(AuthApiUrl.AUTH_V1_BASE_URL + AuthApiUrl.AUTH_CREATE_TOKEN)
                                .content(objectMapper.writeValueAsString(authCreateTokenReqDto))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(authCreateTokenRspDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;
    }
}