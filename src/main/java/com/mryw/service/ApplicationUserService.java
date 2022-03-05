package com.mryw.service;

import com.mryw.model.UserMryw;
import com.mryw.repository.UserMrywRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {
    private final UserMrywRepository userMrywRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserMryw> userMrywOptional = userMrywRepository.findByEmail(email);
        if(userMrywOptional.isPresent()){
            log.info("Found and logging in user: " + email);
            return userMrywOptional.get();
        }
        throw new UsernameNotFoundException("Can't find user with email: " + email);
    }
}
