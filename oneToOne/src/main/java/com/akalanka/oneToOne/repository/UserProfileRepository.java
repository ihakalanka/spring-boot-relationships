package com.akalanka.oneToOne.repository;

import com.akalanka.oneToOne.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
