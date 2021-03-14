package com.learn.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
