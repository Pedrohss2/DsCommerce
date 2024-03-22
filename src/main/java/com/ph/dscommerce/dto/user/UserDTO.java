package com.ph.dscommerce.dto.user;

import com.ph.dscommerce.entities.User;
import com.ph.dscommerce.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String password;
    private UserRole role;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        login = user.getLogin();
        password = user.getPassword();
        role = user.getRole();
    }


}
