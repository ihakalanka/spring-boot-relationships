package com.akalanka.oneToOne.repository;

import com.akalanka.oneToOne.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
