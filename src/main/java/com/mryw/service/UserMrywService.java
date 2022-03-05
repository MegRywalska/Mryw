package com.mryw.service;


import com.mryw.dto.UserMrywDTO;
import com.mryw.dto.UserMrywRequestDTO;
import com.mryw.mapper.UserMrywMapper;
import com.mryw.model.StatusAccount;
import com.mryw.model.UserMryw;
import com.mryw.repository.UserMrywRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMrywService {

    private final UserMrywRepository userMrywRepository;
    private final UserMrywMapper userMrywMapper;
    private final BCryptPasswordEncoder encoder;

    public UserMrywDTO getUserMrywById(Long id){
        return UserMrywDTO.fromUserMryw(userMrywRepository.getById(id));
    }

    public List<UserMrywDTO>  getUsersMryw(){
        return userMrywRepository.findAll()
                .stream()
                .map(userMrywMapper::mapUserMrywToUserMrywDto)
                .collect(Collectors.toList());
    }

    public UserMrywDTO createUserMryw(UserMrywRequestDTO createRequest) {
        UserMryw userMryw = userMrywMapper.mapUserMrywRequestDTOToUserMryw(createRequest);

        // szyfrowanie hasła
        userMryw.setPassword(encoder.encode(createRequest.getPassword()));

        userMryw.setStatusAccount(StatusAccount.OFFLINE);
        userMryw.setCreationDate(LocalDate.now());
        userMryw.setHearts(new HashSet<>());
        userMryw.setComments(new HashSet<>());

         return UserMrywDTO.fromUserMryw(userMrywRepository.save(userMryw));
    }

    public void deleteUserMrywById(Long id) {
        userMrywRepository.deleteById(id);
    }

    public UserMrywDTO updateUserMrywById(Long id, UserMrywRequestDTO updatedInformation) {
        Optional<UserMryw> searchedUserOptional = userMrywRepository.findById(id);
        if ( searchedUserOptional.isPresent()){
            UserMryw user = searchedUserOptional.get();

            user.setAccountName(updatedInformation.getAccountName());
            user.setAccountURL(updatedInformation.getAccountURL());
            user.setEmail(updatedInformation.getEmail());
            user.setPassword(updatedInformation.getPassword());

            return UserMrywDTO.fromUserMryw(userMrywRepository.save(user));
        }

        throw new EntityNotFoundException("Didn't find user with id: " + id);
    }
}

