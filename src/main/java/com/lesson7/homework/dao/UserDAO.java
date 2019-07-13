package com.lesson7.homework.dao;

import com.lesson7.homework.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAO {
    private static final String getUserByName = "SELECT * FROM USERS WHERE NAME = ?";

    @PersistenceContext
    private EntityManager entityManager;

    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    public User getByName(String name){
        return (User) entityManager.createNativeQuery(getUserByName,User.class)
                .setParameter(1, name)
                .getSingleResult();
    }

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
    }

    public User update(User user) {
        return entityManager.merge(user);
    }
}
