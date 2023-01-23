package com.akalanka.oneToMany.repository;

import com.akalanka.oneToMany.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
