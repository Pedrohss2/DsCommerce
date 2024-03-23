package com.ph.dscommerce.dto.user;

import com.ph.dscommerce.entities.User;
import com.ph.dscommerce.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String phone;
    private LocalDate birthDate;
    private UserRole roles;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        login = user.getLogin();
        phone = user.getPhone();
        birthDate = user.getBirthDate();
        roles = user.getRole();
    }


}
