package com.mryw.configuration;

import com.mryw.model.UserMryw;
import com.mryw.repository.UserMrywRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitialDatabaseEntriesConfigurer implements ApplicationListener<ContextRefreshedEvent> {
    private final static String ADMIN_USERNAME = "admin";
    private final static String ADMIN_PASSWORD = "nimda";

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMrywRepository userMrywRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createUsers();
    }

    private void createUsers() {
        addUserIfNotExist(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    private void addUserIfNotExist(String username, String password) {
        if(!userMrywRepository.existsByEmail(username)){

            UserMryw user = UserMryw.builder()
                    .email(username)
                    .password(bCryptPasswordEncoder.encode(password))
                    .build();

            userMrywRepository.save(user);
        }
    }
}
