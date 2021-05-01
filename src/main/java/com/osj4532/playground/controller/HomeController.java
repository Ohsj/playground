package com.osj4532.playground.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 210417 | osj4532 | created
 */

@RestController
@RequestMapping("/")
@Tag(name = "HomeController", description = "PlayGround Home")
public class HomeController extends BaseController{

    @GetMapping
    @Operation(summary = "This is PlayGround", description = "This is PlayGround")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PlayGround is Success"),
            @ApiResponse(responseCode = "500", description = "PlayGround is Fail")
    })
    public String playground() {
        return "This is PlayGround";
    }
}
