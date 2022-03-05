package com.mryw.controller;

import com.mryw.dto.UserMrywDTO;
import com.mryw.dto.UserMrywRequestDTO;
import com.mryw.service.UserMrywService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserMrywController {

    private final UserMrywService userMrywService;

    @GetMapping("")
    public List<UserMrywDTO> getUsers() {
        return userMrywService.getUsersMryw();
    }

    @GetMapping("/{id}")
    public UserMrywDTO getUser(@PathVariable(name = "id") Long id) {

        return userMrywService.getUserMrywById(id);
    }

    @PutMapping("/")
    public UserMrywDTO putUser(@RequestBody UserMrywRequestDTO userMrywDTO) {
        return userMrywService.createUserMryw(userMrywDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {

        userMrywService.deleteUserMrywById(id);
    }

    @PatchMapping("/{id}")
    public UserMrywDTO updateUser(@PathVariable(name = "id") Long id, @RequestBody UserMrywRequestDTO updatedInformation) {
        return userMrywService.updateUserMrywById(id, updatedInformation);
    }


}
