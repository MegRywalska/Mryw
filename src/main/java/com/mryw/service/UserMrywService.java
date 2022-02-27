package com.mryw.service;


import com.mryw.dto.UserMrywDTO;
import com.mryw.model.StatusAccount;
import com.mryw.model.UserMryw;
import com.mryw.repository.UserMrywRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserMrywService {

    private final UserMrywRepository userMrywRepository;

    public UserMryw getUserMrywById(Long id){
        return userMrywRepository.getById(id);
    }

    public List<UserMryw>  getUsersMryw(){
        return userMrywRepository.findAll();
    }

    public UserMryw createUserMryw(UserMrywDTO createRequest) {
        UserMryw userMryw = UserMryw.builder()
                .email(createRequest.getEmail())
                .accountName(createRequest.getAccountName())
                .accountURL(createRequest.getAccountURL())
                .password(createRequest.getPassword())
                .statusAccount(StatusAccount.OFFLINE)
                .creationDate(LocalDate.now()) // opcjonalne
                .build();

        return userMrywRepository.save(userMryw);
    }

    public void deleteUserMrywById(Long id) {
        userMrywRepository.deleteById(id);
    }

    public UserMryw updateUserMrywById(Long id, UserMrywDTO updatedInformation) {
        Optional<UserMryw> searchedUserOptional = userMrywRepository.findById(id);
        if ( searchedUserOptional.isPresent()){
            UserMryw user = searchedUserOptional.get();

            user.setAccountName(updatedInformation.getAccountName());
            user.setAccountURL(updatedInformation.getAccountURL());
            user.setEmail(updatedInformation.getEmail());
            user.setPassword(updatedInformation.getPassword());

            return userMrywRepository.save(user);
        }

        throw new EntityNotFoundException("Didn't find user with id: " + id);
    }
}

