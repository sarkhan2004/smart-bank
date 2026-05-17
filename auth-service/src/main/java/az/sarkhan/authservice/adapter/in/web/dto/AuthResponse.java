package az.sarkhan.authservice.adapter.in.web.dto;

public record AuthResponse(
        String token,
        String username
) {}