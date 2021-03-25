package com.tmmcod.blog.repository;

import com.tmmcod.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Post, Long> {
}
