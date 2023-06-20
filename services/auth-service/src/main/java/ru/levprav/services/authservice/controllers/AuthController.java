package ru.levprav.services.authservice.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.levprav.services.authservice.services.AuthService;
import ru.levprav.services.authservice.vo.JwtRequest;
import ru.levprav.services.authservice.vo.JwtResponse;
import ru.levprav.services.authservice.vo.RefreshRequest;
import ru.levprav.services.authservice.vo.SignUpDto;


@RestController
@RequiredArgsConstructor
@RequestMapping("a")
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        JwtResponse tokens = authService.login(jwtRequest);
        return ResponseEntity.ok(tokens);
    }

    @PostMapping("signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody @Valid SignUpDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors().get(0).getDefaultMessage());
        JwtResponse tokens = authService.signup(dto);
        return ResponseEntity.ok(tokens);
    }

    @PostMapping("access")
    public ResponseEntity<JwtResponse> getAccessToken(@RequestBody RefreshRequest request) {
        JwtResponse tokens = authService.getTokensByRefresh(request.getRefreshToken(), false);
        return ResponseEntity.ok(tokens);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getRefreshToken(@RequestBody RefreshRequest request) {
        JwtResponse tokens = authService.getTokensByRefresh(request.getRefreshToken(), true);
        return ResponseEntity.ok(tokens);
    }
}
