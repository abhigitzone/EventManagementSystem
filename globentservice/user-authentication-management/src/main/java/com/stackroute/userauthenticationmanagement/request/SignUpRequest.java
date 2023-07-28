package com.stackroute.userauthenticationmanagement.request;


import lombok.*;

import java.util.Set;

import javax.validation.constraints.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class SignUpRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email

    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(max = 10)
    private String phone;

}
