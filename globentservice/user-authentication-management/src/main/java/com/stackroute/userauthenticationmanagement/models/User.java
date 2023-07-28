package com.stackroute.userauthenticationmanagement.models;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")}
)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Generated
@EqualsAndHashCode
@Getter
@Setter
public class User {



    @Column(columnDefinition = "BIGINT(20) NOT NULL UNIQUE KEY auto_increment")

    private Long id;


    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max=10)
    private String phone;

    @Id
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_email"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    public User(String username, String email, String password,String phone) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhone(phone);
    }

}
