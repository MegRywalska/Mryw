package com.mryw.controller;

import com.mryw.dto.PostDTO;
import com.mryw.model.Post;
import com.mryw.repository.PostRepository;
import com.mryw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final PostDTO postDTO;

    @GetMapping("")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable (name = "id") Long id){
        return postService.getPostById(id);
    }

    @PutMapping
    public Post putPost(@RequestBody PostDTO postDTO){
        return postService.createPost(postDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable (name = "id") Long id){
        postService.deletePostById(id);
    }

    @PatchMapping("/{id}")
    public Post updatePost(@PathVariable(name = "id") Long id, @RequestBody PostDTO updatePost){
        return postService.updatePostById(id, updatePost);
    }







}
