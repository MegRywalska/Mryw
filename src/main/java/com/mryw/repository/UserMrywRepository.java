package com.mryw.repository;

import com.mryw.model.UserMryw;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository

public interface UserMrywRepository extends JpaRepository <UserMryw, Long>  {





}
