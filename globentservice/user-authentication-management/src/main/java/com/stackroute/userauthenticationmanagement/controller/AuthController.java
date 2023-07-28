package com.stackroute.userauthenticationmanagement.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.stackroute.userauthenticationmanagement.models.ERole;
import com.stackroute.userauthenticationmanagement.models.Role;
import com.stackroute.userauthenticationmanagement.models.User;
import com.stackroute.userauthenticationmanagement.repository.RoleRepository;
import com.stackroute.userauthenticationmanagement.repository.UserRepository;
import com.stackroute.userauthenticationmanagement.request.SigninRequest;
import com.stackroute.userauthenticationmanagement.request.SignUpRequest;
import com.stackroute.userauthenticationmanagement.response.JwtResponse;
import com.stackroute.userauthenticationmanagement.response.MessageResponse;
import com.stackroute.userauthenticationmanagement.security.Jwt.JwtUtils;
import com.stackroute.userauthenticationmanagement.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninRequest signinRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPhone(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getPhone());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role participantRole = roleRepository.findByName(ERole.ROLE_PARTICIPANT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(participantRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "organiser":
                        Role organiserRole = roleRepository.findByName(ERole.ROLE_ORGANISER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(organiserRole);

                        break;
                    case "participant":
                        Role participantRole = roleRepository.findByName(ERole.ROLE_PARTICIPANT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(participantRole);
                        break;
                    default:
                        new RuntimeException("Error: Role is invalid.");
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
