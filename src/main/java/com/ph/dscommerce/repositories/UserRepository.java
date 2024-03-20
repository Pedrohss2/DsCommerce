package com.ph.dscommerce.repositories;

import java.util.List;

import com.ph.dscommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	UserDetails findByLogin(String login);

}
