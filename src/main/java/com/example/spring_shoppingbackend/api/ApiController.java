package com.example.spring_shoppingbackend.api;
import com.example.spring_shoppingbackend.entity.dto.UserInfoDto;
import com.example.spring_shoppingbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ApiController {
    final AccountService accountService;

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public UserInfoDto getUser(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        return accountService.getUserInfo(authorizationHeader);
    }

    @RequestMapping(value = "/user/get-admin", method = RequestMethod.GET)
    public UserInfoDto getAdmin(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        return accountService.getUserInfo(authorizationHeader);
    }
}
