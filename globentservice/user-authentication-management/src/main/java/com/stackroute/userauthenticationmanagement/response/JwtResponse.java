package com.stackroute.userauthenticationmanagement.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;

    private String phone;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String username, String email,String phone, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone=phone;
        this.roles = roles;
    }
}
