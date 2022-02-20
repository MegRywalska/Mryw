package com.mryw.repository;

import com.mryw.model.UserMryw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMrywRepository extends JpaRepository <UserMryw, String>  {


}
