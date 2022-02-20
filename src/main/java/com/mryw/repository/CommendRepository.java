package com.mryw.repository;

import com.mryw.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommendRepository extends JpaRepository<Comment, Long> {
}
