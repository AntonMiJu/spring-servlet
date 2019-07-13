package com.lesson7.homework.service;

import com.lesson7.homework.dao.PostDAO;
import com.lesson7.homework.models.Filter;
import com.lesson7.homework.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostDAO postDAO;

    @Autowired
    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public Post get(Long id) {
        return postDAO.get(id);
    }

    public Post save(Post post) {
        return postDAO.save(post);
    }

    public void delete(Long id) {
        postDAO.delete(id);
    }

    public Post update(Post post) {
        return postDAO.update(post);
    }

    public List<Post> getAllAvailablePosts() {
        return postDAO.getAllAvailablePosts();
    }

    public List<Post> getPostsByFilter(Filter filter) {
        return postDAO.getPostsByFilter(filter);
    }
}
