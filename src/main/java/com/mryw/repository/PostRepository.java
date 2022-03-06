package com.mryw.repository;

import com.mryw.model.Post;
import com.mryw.model.UserMryw;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCreatorPost(UserMryw userMryw);
}
