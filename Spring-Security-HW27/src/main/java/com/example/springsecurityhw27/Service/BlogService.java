package com.example.springsecurityhw27.Service;


import com.example.springsecurityhw27.ApiException.ApiException;
import com.example.springsecurityhw27.Model.Blog;
import com.example.springsecurityhw27.Model.MyUser;
import com.example.springsecurityhw27.Repository.AuthRepository;
import com.example.springsecurityhw27.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;


    public List<Blog> getBlogs(MyUser myUser){
        return blogRepository.findAllByMyUser(myUser);
    }

    public void addBlog(MyUser myUser, Blog blog){

        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }

    public void updateBlog(MyUser myUser, Blog blog, Integer blogId){

        Blog blog1=blogRepository.findBlogById(blogId);

        if (blog1==null){
            throw  new ApiException("Blogg not found");
        }
        if (blog1.getMyUser() != myUser){
            throw new ApiException("Error, not authorized");
        }

        blog1.setTitle(blog.getTitle());
        blog1.setBody(blog.getBody());
        blogRepository.save(blog1);
    }

    public void deleteBlog(MyUser myUser, Integer blogId){
        Blog blog1=blogRepository.findBlogById(blogId);
        if (blog1.getMyUser() != myUser){
            throw new ApiException("Error, not authorized");
        }
        blogRepository.delete(blog1);
    }


    public Blog getBlogById(MyUser myUser, Integer blogId){
        Blog blog1=blogRepository.findBlogById(blogId);
        if (blog1==null){
            throw  new ApiException("Blog not found");
        }
        if (blog1.getMyUser() != myUser){
            throw new ApiException("Error, not authorized");
        }
        return blog1;

    }

    public Blog getBlogByTitle(MyUser myUser, String title){
        Blog blog1=blogRepository.findBlogByTitle(title);
        if (blog1==null){
            throw  new ApiException("Blog not found");
        }
        if (blog1.getMyUser() != myUser){
            throw new ApiException("Error, not authorized");
        }
        return blog1;

    }


}
