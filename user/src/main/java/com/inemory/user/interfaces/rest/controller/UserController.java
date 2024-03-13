package com.inemory.user.interfaces.rest.controller;

import com.inemory.user.application.commandservice.UserLoginCommandService;
import com.inemory.user.domain.model.command.UserLoginCommand;
import com.inemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inemory.user.interfaces.rest.dto.UserLoginReqDto;
import com.inemory.user.interfaces.rest.dto.UserLoginRspDto;
import com.inemory.user.interfaces.rest.mapper.UserLoginCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inemory.user.interfaces.rest.constants.UserApiUrl.LOGIN_URL;
import static com.inemory.user.interfaces.rest.constants.UserApiUrl.USER_V1_BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_V1_BASE_URL)
public class UserController {

    private final UserLoginCommandService userLoginCommandService;

    private final UserLoginCommandMapper userLoginCommandMapper;

    /**
     * 로그인
     * 토큰을 응답 값으로 전달받는다.
     *
     * @param userLoginReqDto 로그인 요청 Dto
     * @return 토큰 생성 결과 값을 담은 응답
     */
    @PostMapping(LOGIN_URL)
    public ResponseEntity<Object> login(@RequestBody UserLoginReqDto userLoginReqDto) {
        UserLoginCommand userLoginCommand = userLoginCommandMapper.mapToCommand(userLoginReqDto);
        AuthCreateTokenVo authCreateTokenVo = userLoginCommandService.login(userLoginCommand);
        UserLoginRspDto userLoginRspDto = userLoginCommandMapper.mapToRspDto(authCreateTokenVo);
        return new ResponseEntity<>(userLoginRspDto, HttpStatus.OK);
    }
}
