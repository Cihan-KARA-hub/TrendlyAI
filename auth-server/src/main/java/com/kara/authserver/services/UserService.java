package com.kara.authserver.services;


import com.kara.authserver.api.dto.*;
import com.kara.authserver.client.KeycloakAdminClient;
import com.kara.authserver.client.KeycloakUserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {


    private final KeycloakUserClient keycloakUserClient;
    private final KeycloakAdminClient keycloakAdminClient;
   // @Value("admin")
    private final String admin_username="test-user";
    //@Value("admin")
    private final String admin_password="user1";

    public UserService(KeycloakUserClient keycloakUserClient, KeycloakAdminClient keycloakAdminClient) {
        this.keycloakUserClient = keycloakUserClient;
        this.keycloakAdminClient = keycloakAdminClient;
    }

    public TokenResponseDto getToken(String username, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("client_id", "trendly-auth");
        body.put("username", username);
        body.put("password", password);
        body.put("grant_type", "password");
        body.put("client_secret", "9A4XISA2PlQHrMV7TLbg3EubK8RbuZ2R");
        return keycloakUserClient.token(body);
    }

    public TokenResponseDto getUserToken(String username, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("client_id", "trendly-auth");
        body.put("username", username);
        body.put("password", password);
        body.put("grant_type", "password");
        body.put("client_secret", "9A4XISA2PlQHrMV7TLbg3EubK8RbuZ2R");
        body.put("scope", "openid profile email");
        return keycloakUserClient.token(body);
    }

    public List<UserResponseDto> getAllUsers() {
        TokenResponseDto token = getToken(admin_username, admin_password);
        return keycloakAdminClient.getAllUsers(token.getBearerToken());
    }

    public UserResponseDto getByIdUser(String id) {
        TokenResponseDto token = getToken(admin_username, admin_password);
        return keycloakUserClient.getByIdUser(token.getBearerToken(), id);
    }

    public void createUser(CreateUserDto createUserDto) {
        TokenResponseDto token = getToken(admin_username, admin_password);
        String accessToken = token.getBearerToken();
        Map<String, Object> body = new HashMap<>();
        body.put("enabled", Boolean.parseBoolean(String.valueOf(createUserDto.isEnabled())));
        body.put("username", createUserDto.getUsername());
        body.put("firstName", createUserDto.getFirstName());
        body.put("emailVerified",false);
        body.put("lastName", createUserDto.getLastName());
        body.put("email", createUserDto.getEmail());
        keycloakAdminClient.createUser(body, accessToken);
    }

    public void userDelete(String id) {
        TokenResponseDto token = getToken(admin_username, admin_password);
        String accessToken = token.getBearerToken();
        keycloakAdminClient.deleteUser(accessToken, id);
    }

    public void updateUser(UserUpdateDto userUpdateDto, String id) {
        TokenResponseDto token = getToken(admin_username, admin_password);
        String accessToken = token.getBearerToken();
        Map<String, Object> body = new HashMap<>();
        body.put("enabled", Boolean.parseBoolean(String.valueOf(userUpdateDto.isEnabled())));
        body.put("username", userUpdateDto.getUsername());
        body.put("firstName", userUpdateDto.getFirstName());
        body.put("lastName", userUpdateDto.getLastName());
        body.put("email", userUpdateDto.getEmail());

        // Logging to check if ID and body content are correct
        System.out.println("Updating user with ID: " + id);
        System.out.println("Request body: " + body);

        keycloakAdminClient.updateUser(body, accessToken, id);
    }

    public void resetPassword(UserPasswordDto userPasswordDto, String id) {
        TokenResponseDto token = getToken(admin_username, admin_password);
        String accessToken = token.getBearerToken();
        Map<String, Object> body = new HashMap<>();
        body.put("type", userPasswordDto.getType());
        body.put("value", userPasswordDto.getValue());
        body.put("temporary", Boolean.parseBoolean(String.valueOf(userPasswordDto.isTemporary())));

        System.out.println("req " + userPasswordDto.getValue());

        keycloakAdminClient.resetPassword(accessToken, id, body);
    }


}