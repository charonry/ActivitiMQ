package com.charon.boot.mapper;

import com.charon.boot.model.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAUserRepository extends JpaRepository<JPAUser,Integer> {
     List<JPAUser> findAll();
}
