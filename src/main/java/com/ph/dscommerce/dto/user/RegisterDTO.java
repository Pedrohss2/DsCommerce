package com.ph.dscommerce.dto.user;

import com.ph.dscommerce.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    public String name;
    public String login;
    public String password;
    private String phone;
    private LocalDate birthDate;
    public UserRole role;

}
