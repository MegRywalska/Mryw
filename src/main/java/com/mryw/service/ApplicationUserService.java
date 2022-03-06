package com.mryw.service;

import com.mryw.model.UserMryw;
import com.mryw.repository.UserMrywRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
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

    public Optional<Long> getLoggedInUserId(Principal principal){
        if (principal != null){
            log.info("Jesteśmy zalogowani, informacja o użytkowniku: " + principal);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) principal;
            try{
                UserMryw userDetails = (UserMryw) loadUserByUsername((String) usernamePasswordAuthenticationToken.getPrincipal());
                return Optional.of(userDetails.getId());
            }catch (UsernameNotFoundException usernameNotFoundException){
                log.info("Nie jesteśmy zalogowani");
            }
        }
        return Optional.empty();
    }
}
