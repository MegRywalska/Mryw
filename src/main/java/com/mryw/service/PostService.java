package com.mryw.service;


import com.mryw.dto.PostDTO;
import com.mryw.model.Post;
import com.mryw.model.UserMryw;
import com.mryw.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
       return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    public Post createPost(PostDTO createRequest) {
        Post post = Post.builder().text(createRequest.getText()).build();

        return postRepository.save(post);

    }
    public void deletePostById(Long id) {
        postRepository.deleteById(id);

    }

    public Post updatePostById(Long id, PostDTO updateInformation) {
        Optional<Post> searchedPostOptional = postRepository.findById(id);
        if (searchedPostOptional.isPresent()){
            Post post = searchedPostOptional.get();

            post.setText(updateInformation.getText());

            return postRepository.save(post);
        }

        throw new EntityNotFoundException("Didn't find post with id: " + id);

    }
}
