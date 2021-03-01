package me.jimbae.demoinflearnrestapi.accounts;

import me.jimbae.demoinflearnrestapi.common.BaseTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountServiceTest extends BaseTest {

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void findByUsername(){
        // GIVEN
        String password = "jimbae";
        String username = "jimbae@gmail.com";

        Account account = Account.builder()
                .email(username)
                .password(password)
                .roles(Set.of(AccountRole.ADMIN, AccountRole.USER ))
                .build();

        accountService.saveAccount(account);

        // WHEN
        UserDetailsService userDetailsService = (UserDetailsService) accountService;
        var userDetails = userDetailsService.loadUserByUsername(username);

        // THEN
        assertThat(this.passwordEncoder.matches(password, userDetails.getPassword())).isTrue();
        System.out.println(userDetails.getPassword());
    }

    @Test
    public void findByUsernameFail() throws Exception {
        //end
        assertThrows(UsernameNotFoundException.class, () -> {
            accountService.loadUserByUsername("random@email.com");
        });
    }

}