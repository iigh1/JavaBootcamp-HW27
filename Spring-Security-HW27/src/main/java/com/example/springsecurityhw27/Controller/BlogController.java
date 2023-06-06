package com.example.springsecurityhw27.Controller;


import com.example.springsecurityhw27.Model.Blog;
import com.example.springsecurityhw27.Model.MyUser;
import com.example.springsecurityhw27.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity getBlogs(@AuthenticationPrincipal MyUser myUser){
        List<Blog> blogs = blogService.getBlogs(myUser);
        return ResponseEntity.status(200).body(blogs);

    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog){

        blogService.addBlog(myUser, blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PostMapping("/update/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog,@PathVariable Integer blogId){
        blogService.updateBlog(myUser, blog,blogId);
        return ResponseEntity.status(200).body("Blog updated");

    }

    @DeleteMapping("/delete{blogId}")

    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId){
        blogService.deleteBlog(myUser,blogId);
        return ResponseEntity.status(200).body("Blog deleted");
    }

    @GetMapping("/get-id/{blogId}")
    public ResponseEntity getBlogById(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId){
        Blog blog = blogService.getBlogById(myUser,blogId);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-title/{blogTitle}")
    public ResponseEntity getBlogById(@AuthenticationPrincipal MyUser myUser, @PathVariable String blogTitle){
        Blog blog = blogService.getBlogByTitle(myUser, blogTitle);
        return ResponseEntity.status(200).body(blog);
    }

}
