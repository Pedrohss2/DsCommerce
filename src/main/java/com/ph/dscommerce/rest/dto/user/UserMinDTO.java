package com.ph.dscommerce.rest.dto.user;

import com.ph.dscommerce.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserMinDTO {

    private Long id;
    private String name;

    public UserMinDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

}
