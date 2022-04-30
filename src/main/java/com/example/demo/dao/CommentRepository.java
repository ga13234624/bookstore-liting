package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
