package com.example.spring_shoppingbackend.api;

import com.example.spring_shoppingbackend.entity.dto.RegisterDto;
import com.example.spring_shoppingbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    final AccountService accountService;

    @RequestMapping(value = "/register", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(accountService.register(registerDto));
    }

}
