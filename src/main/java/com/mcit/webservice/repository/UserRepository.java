package com.mcit.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcit.webservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
