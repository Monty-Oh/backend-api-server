package com.inemory.user.interfaces.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inemory.user.interfaces.rest.constants.UserApiUrl.LOGIN_URL;
import static com.inemory.user.interfaces.rest.constants.UserApiUrl.USER_V1_BASE_URL;

@RestController
@RequestMapping(USER_V1_BASE_URL)
public class UserController {

    @PostMapping(LOGIN_URL)
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }
}
