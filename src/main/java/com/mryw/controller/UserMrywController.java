package com.mryw.controller;

import com.mryw.dto.UserMrywDTO;
import com.mryw.model.UserMryw;
import com.mryw.service.UserMrywService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserMrywController {

    private final UserMrywService userMrywService;

    @GetMapping("/list_user")
    public List<UserMryw> getUsers() {

        return userMrywService.getUsersMryw();
    }

    @GetMapping("/findId_user/{id}")
    public UserMryw getUser(@PathVariable(name = "id") Long id) {

        return userMrywService.getUserMrywById(id);
    }

    @PutMapping("/user")
    public UserMryw putUser(@RequestBody UserMrywDTO userMrywDTO) {
        return userMrywService.createUserMryw(userMrywDTO);
    }

    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {

        userMrywService.deleteUserMrywById(id);
    }

    @PatchMapping("/update_user/{id}")
    public UserMryw updateUser(@PathVariable(name = "id") Long id, @RequestBody UserMrywDTO updatedInformation) {
        return userMrywService.updateUserMrywById(id, updatedInformation);
    }


}
