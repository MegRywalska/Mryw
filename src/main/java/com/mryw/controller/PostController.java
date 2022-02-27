package com.mryw.controller;

import com.mryw.dto.PostCreateDTO;
import com.mryw.dto.PostDTO;
import com.mryw.model.Post;
import com.mryw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("")
    public List<PostDTO> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable (name = "id") Long id){
        return postService.getPostById(id);
    }

    @PutMapping
    public PostDTO putPost(@RequestBody PostCreateDTO postDTO){
        return postService.createPost(postDTO);
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
