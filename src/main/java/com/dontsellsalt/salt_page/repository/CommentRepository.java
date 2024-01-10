package com.dontsellsalt.salt_page.repository;

import com.dontsellsalt.salt_page.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
