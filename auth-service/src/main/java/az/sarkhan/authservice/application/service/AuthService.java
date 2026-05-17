package az.sarkhan.authservice.application.service;

import az.sarkhan.authservice.adapter.in.web.dto.AuthResponse;
import az.sarkhan.authservice.adapter.in.web.dto.LoginRequest;
import az.sarkhan.authservice.adapter.in.web.dto.RegisterRequest;
import az.sarkhan.authservice.adapter.in.web.security.JwtUtil;
import az.sarkhan.authservice.application.port.in.LoginUseCase;
import az.sarkhan.authservice.application.port.in.RegisterUseCase;
import az.sarkhan.authservice.application.port.out.UserRepository;
import az.sarkhan.authservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements RegisterUseCase, LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(
                null,
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password())
        );

        userRepository.save(user);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password(), user.password())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.email());
        return new AuthResponse(token, user.username());
    }
}
