package az.sarkhan.authservice.domain.model;

public record User(
        Long id,
        String username,
        String email,
        String password
) {}