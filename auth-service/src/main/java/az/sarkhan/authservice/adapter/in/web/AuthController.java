package az.sarkhan.authservice.adapter.in.web;

import az.sarkhan.authservice.adapter.in.web.dto.AuthResponse;
import az.sarkhan.authservice.adapter.in.web.dto.LoginRequest;
import az.sarkhan.authservice.adapter.in.web.dto.RegisterRequest;
import az.sarkhan.authservice.application.port.in.LoginUseCase;
import az.sarkhan.authservice.application.port.in.RegisterUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUseCase registerUseCase;
    private final LoginUseCase loginUseCase;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequest request) {
        registerUseCase.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = loginUseCase.login(request);
        return ResponseEntity.ok(response);
    }
}
