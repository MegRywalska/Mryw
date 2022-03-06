package com.mryw.service;


import com.mryw.dto.PostCreateDTO;
import com.mryw.dto.PostDTO;
import com.mryw.model.Post;
import com.mryw.model.StatusPost;
import com.mryw.model.UserMryw;
import com.mryw.repository.PostRepository;
import com.mryw.repository.UserMrywRepository;
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
    private final UserMrywRepository userMrywRepository;

    public List<PostDTO> getPosts(Long userId) {
        Optional<UserMryw> userMrywOptional = userMrywRepository.findById(userId);
        if(userMrywOptional.isPresent()) {
            return postRepository.findAllByCreatorPost(userMrywOptional.get())
                    .stream()
                    .map(PostDTO::fromPost)
                    .collect(Collectors.toList());
        }

        throw new EntityNotFoundException("Unable to find user.");
    }

    public PostDTO getPostById(Long id) {
        return PostDTO.fromPost(postRepository.getById(id));
    }

    public PostDTO createPost(PostCreateDTO createRequest, Long userId) {
        Optional<UserMryw> userMrywOptional = userMrywRepository.findById(userId);
        if(userMrywOptional.isPresent()) {
            Post post = Post.builder()
                    .statusPost(StatusPost.ORIGINAL)
                    .text(createRequest.getText())
                    .comments(new HashSet<>())
                    .hearts(new HashSet<>())
                    .creatorPost(userMrywOptional.get())
                    .build();

            return PostDTO.fromPost(postRepository.save(post));
        }

        throw new EntityNotFoundException("Unable to find user.");
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
