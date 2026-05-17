package az.sarkhan.authservice.application.port.in;

import az.sarkhan.authservice.adapter.in.web.dto.RegisterRequest;

public interface RegisterUseCase {
    void register(RegisterRequest request);
}
