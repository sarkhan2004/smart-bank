package az.sarkhan.authservice.application.port.in;

import az.sarkhan.authservice.adapter.in.web.dto.LoginRequest;
import az.sarkhan.authservice.adapter.in.web.dto.AuthResponse;

public interface LoginUseCase {
    AuthResponse login(LoginRequest request);
}
