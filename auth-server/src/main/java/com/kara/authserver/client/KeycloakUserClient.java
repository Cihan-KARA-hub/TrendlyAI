package com.kara.authserver.client;



import com.kara.authserver.api.dto.TokenResponseDto;
import com.kara.authserver.api.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "keycloakAdminClient", url = "http://localhost:8090/realms/trendly-auth")
public interface KeycloakUserClient {
    @PostMapping(value = "/protocol/openid-connect/token", consumes = "application/x-www-form-urlencoded")
        TokenResponseDto token(Map<String, ?> form);

    @GetMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserResponseDto getByIdUser(@RequestHeader("Authorization") String token, @PathVariable String id);

}
