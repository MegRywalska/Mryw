package com.mryw.controller;

import com.mryw.dto.PostCreateDTO;
import com.mryw.dto.PostDTO;
import com.mryw.model.Post;
import com.mryw.service.ApplicationUserService;
import com.mryw.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final ApplicationUserService applicationUserService;

    @GetMapping("")
    public List<PostDTO> getPosts(Principal principal){
        Optional<Long> userIdOptional = applicationUserService.getLoggedInUserId(principal);
        if(userIdOptional.isPresent()) {
            return postService.getPosts(userIdOptional.get());
        }

        throw new EntityNotFoundException("Not logged in.");
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable (name = "id") Long id){
        return postService.getPostById(id);
    }

    @PutMapping
    public PostDTO putPost(Principal principal, @RequestBody PostCreateDTO postDTO){
        Optional<Long> userIdOptional = applicationUserService.getLoggedInUserId(principal);
        if(userIdOptional.isPresent()) {
            return postService.createPost(postDTO, userIdOptional.get());
        }

        throw new EntityNotFoundException("Not logged in.");
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable (name = "id") Long id){
        postService.deletePostById(id);
    }

    @PatchMapping("/{id}")
    public Post updatePost(@PathVariable(name = "id") Long id, @RequestBody PostCreateDTO updatePost){
        return postService.updatePostById(id, updatePost);
    }







}
