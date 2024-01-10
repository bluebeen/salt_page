package com.dontsellsalt.salt_page.controller;

import com.dontsellsalt.salt_page.entity.Comment;
import com.dontsellsalt.salt_page.entity.Post;
import com.dontsellsalt.salt_page.repository.CommentRepository;
import com.dontsellsalt.salt_page.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public String listPosts(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        model.addAttribute("editPost", new Post());
        model.addAttribute("newComment", new Comment());
        return "post/list";
    }

    @PostMapping
    public String addPost(@ModelAttribute Post newPost, Principal principal) {
        // Principal을 통해 현재 로그인한 사용자의 정보를 가져옴
        newPost.setAuthor(principal.getName());
        newPost.setCreatedAt(LocalDateTime.now());
        postRepository.save(newPost);
        return "redirect:/posts";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute Post editPost) {
        Post post = postRepository.findById(editPost.getId()).orElse(null);
        if (post != null) {
            post.setContent(editPost.getContent());
            postRepository.save(post);
        }
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping("/comments")
    public String addComment(@ModelAttribute Comment newComment, Principal principal) {
        // Principal을 통해 현재 로그인한 사용자의 정보를 가져옴
        newComment.setAuthor(principal.getName());
        Post post = postRepository.findById(newComment.getPost().getId()).orElse(null);

        if (post != null) {
            newComment.setPost(post);
            newComment.setCreatedAt(LocalDateTime.now());
            commentRepository.save(newComment);
        }

        return "redirect:/posts";
    }
}