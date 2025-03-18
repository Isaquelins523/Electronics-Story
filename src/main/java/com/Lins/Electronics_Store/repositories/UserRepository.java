package com.Lins.Electronics_Store.repositories;

import com.Lins.Electronics_Store.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);

}
