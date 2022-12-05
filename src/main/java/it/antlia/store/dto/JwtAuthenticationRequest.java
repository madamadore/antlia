package it.antlia.store.dto;

import lombok.Getter;

@Getter
public class JwtAuthenticationRequest {
    private String username;
    private String password;
}
