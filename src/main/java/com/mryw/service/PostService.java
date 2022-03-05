package com.mryw.service;


import com.mryw.dto.PostCreateDTO;
import com.mryw.dto.PostDTO;
import com.mryw.model.Post;
import com.mryw.model.StatusPost;
import com.mryw.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostDTO> getPosts() {
       return postRepository.findAll()
               .stream()
               .map(post -> PostDTO.fromPost(post))
               .collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id) {
        return PostDTO.fromPost(postRepository.getById(id));
    }

    public PostDTO createPost(PostCreateDTO createRequest) {
        Post post = Post.builder()
                .statusPost(StatusPost.ORIGINAL)
                .text(createRequest.getText())
                .comments(new HashSet<>())
                .hearts(new HashSet<>())
                .build();

        return PostDTO.fromPost(postRepository.save(post));
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);

    }

    public Post updatePostById(Long id, PostCreateDTO updateInformation) {
        Optional<Post> searchedPostOptional = postRepository.findById(id);
        if (searchedPostOptional.isPresent()){
            Post post = searchedPostOptional.get();

            post.setText(updateInformation.getText());

            return postRepository.save(post);
        }

        throw new EntityNotFoundException("Didn't find post with id: " + id);

    }
}
