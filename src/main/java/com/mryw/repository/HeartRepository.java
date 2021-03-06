package com.mryw.repository;

import com.mryw.model.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository <Heart, Long>  {
}
