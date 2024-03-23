package com.ph.dscommerce.controller;

import com.ph.dscommerce.dto.user.AuthenticationDTO;
import com.ph.dscommerce.dto.user.LoginDTO;
import com.ph.dscommerce.dto.user.RegisterDTO;
import com.ph.dscommerce.dto.user.UserDTO;
import com.ph.dscommerce.entities.User;
import com.ph.dscommerce.repositories.UserRepository;
import com.ph.dscommerce.services.AuthorizationService;
import com.ph.dscommerce.services.TokenService;
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
    public ResponseEntity<UserDTO> getMe() {
        UserDTO userDTO = authorizationService.getMe();
        return ResponseEntity.ok(userDTO);
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO dto) {

        if(repository.findByLogin(dto.getLogin()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        User user = new User(dto.name, dto.getLogin(), dto.getPhone(), dto.getBirthDate(), encryptedPassword, dto.getRole());
        this.repository.save(user);

        return ResponseEntity.ok().build();
    }


}
