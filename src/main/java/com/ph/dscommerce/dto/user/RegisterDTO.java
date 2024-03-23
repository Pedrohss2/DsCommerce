package com.ph.dscommerce.dto.user;

import com.ph.dscommerce.entities.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotEmpty(message = "'name' field can't be nul")
    public String name;
    @Email(message = "'email' field need be a true email")
    public String login;
    @NotEmpty(message = "password field cannot be null")
    @Size(min = 5,  message = "'password' field must be longer than 5 characters")
    public String password;
    private String phone;
    private LocalDate birthDate;
    public UserRole role;

}
