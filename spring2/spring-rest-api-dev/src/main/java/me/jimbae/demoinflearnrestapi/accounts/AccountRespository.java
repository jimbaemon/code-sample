package me.jimbae.demoinflearnrestapi.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AccountRespository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String username);
}
