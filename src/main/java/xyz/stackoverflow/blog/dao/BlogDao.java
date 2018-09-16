package xyz.stackoverflow.blog.dao;

import org.springframework.stereotype.Repository;
import xyz.stackoverflow.blog.pojo.entity.Blog;

@Repository
public interface BlogDao {
    int saveBlog(Blog blog);
    Blog getBlogById(String id);
}