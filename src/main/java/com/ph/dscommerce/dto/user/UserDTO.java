package com.ph.dscommerce.dto.user;

import com.ph.dscommerce.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String phone;
    private LocalDate birthDate;
    private List<String> roles = new ArrayList<>();

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        login = user.getLogin();
        phone = user.getPhone();
        birthDate = user.getBirthDate();

        for(GrantedAuthority role : user.getAuthorities()) {
            roles.add(role.getAuthority());
        }
    }


}
