package me.jimbae.demoinflearnrestapi.accounts;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRespository accountRepository;

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

        accountRepository.save(account);

        // WHEN
        UserDetailsService userDetailsService = (UserDetailsService) accountService;
        var userDetails = userDetailsService.loadUserByUsername(username);

        // THEN
        assertThat(userDetails.getPassword()).isEqualTo(password);
    }

}