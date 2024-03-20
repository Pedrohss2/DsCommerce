package com.ph.dscommerce.dto;

import com.ph.dscommerce.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    public String login;
    public String password;
    public UserRole role;
}
