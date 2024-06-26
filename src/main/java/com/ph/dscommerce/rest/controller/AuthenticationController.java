package com.ph.dscommerce.rest.controller;

import com.ph.dscommerce.rest.dto.user.AuthenticationDTO;
import com.ph.dscommerce.rest.dto.user.LoginDTO;
import com.ph.dscommerce.rest.dto.user.RegisterDTO;
import com.ph.dscommerce.rest.dto.user.UserDTO;
import com.ph.dscommerce.domain.entity.User;
import com.ph.dscommerce.domain.repository.UserRepository;
import com.ph.dscommerce.services.AuthorizationService;
import com.ph.dscommerce.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthorizationService authorizationService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/users/me")
    @Operation(summary = "Get user Authentication")
    public ResponseEntity<UserDTO> getMe() {
        UserDTO userDTO = authorizationService.getMe();
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    @Operation(summary = "Login")
    public ResponseEntity<LoginDTO> login(@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@Valid @RequestBody RegisterDTO dto) {

        if(repository.findByLogin(dto.getLogin()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        User user = new User(dto.name, dto.getLogin(), dto.getPhone(), dto.getBirthDate(), encryptedPassword, dto.getRole());
        this.repository.save(user);

        return ResponseEntity.ok().build();
    }


}
