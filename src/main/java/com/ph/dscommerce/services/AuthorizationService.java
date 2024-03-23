package com.ph.dscommerce.services;

import com.ph.dscommerce.dto.user.UserDTO;
import com.ph.dscommerce.entities.User;
import com.ph.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    protected User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return (User) userRepository.findByLogin(username);
        }
        catch (Exception e) {
            throw new UsernameNotFoundException("Invalid user!!");
        }
    }

    @Transactional(readOnly = true)
    public UserDTO getMe() {
        User user = authenticated();
        return new UserDTO(user);
    }
}
