package com.lesson7.homework.dao;

import com.lesson7.homework.models.Filter;
import com.lesson7.homework.models.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PostDAO {
    private static final String getAllAvailablePosts = "SELECT * FROM POSTS WHERE ? BETWEEN DATE_FROM AND DATE_TO ORDER BY DATE_CREATED DESC";
    private static final String getPostsByFilter = "SELECT * FROM POSTS WHERE CATEGORY = ? AND CITY = ? AND DESCRIPTION LIKE ? AND ? BETWEEN DATE_FROM AND DATE_TO";

    @PersistenceContext
    private EntityManager entityManager;

    public Post get(Long id) {
        return entityManager.find(Post.class, id);
    }

    public Post save(Post post) {
        entityManager.persist(post);
        return post;
    }

    public void delete(Long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.detach(post);
    }

    public Post update(Post post) {
        return entityManager.merge(post);
    }

    public List<Post> getAllAvailablePosts() {
        return entityManager.createNativeQuery(getAllAvailablePosts, Post.class)
                .setParameter(1, new Date())
                .setMaxResults(100)
                .getResultList();
    }

    public List<Post> getPostsByFilter(Filter filter) {
        return entityManager.createNativeQuery(getPostsByFilter, Post.class)
                .setParameter(1, filter.getCategory().toString())
                .setParameter(2, filter.getCity())
                .setParameter(3, "'%" + filter.getKeyWord() + "%'")
                .setParameter(4, new Date())
                .getResultList();
    }
}
