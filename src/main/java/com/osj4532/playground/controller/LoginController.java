package com.osj4532.playground.controller;

import com.osj4532.playground.dto.PostLoginIn;
import com.osj4532.playground.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 210619 | osj4532 | created
 */

@RestController
@RequestMapping("/login")
@Tag(name = "LoginController", description = "로그인을 위한 컨트롤러")
public class LoginController extends BaseController{

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @Operation(summary = "login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "login success"),
            @ApiResponse(responseCode = "401", description = "login fail")
    })
    public String getLoginToken(@RequestBody PostLoginIn input) {
        return authService.login(input);
    }
}
