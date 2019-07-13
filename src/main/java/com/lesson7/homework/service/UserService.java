package com.lesson7.homework.service;

import com.lesson7.homework.dao.UserDAO;
import com.lesson7.homework.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User get(Long id) {
        return userDAO.get(id);
    }

    public User getByName(String name) {
        return userDAO.getByName(name);
    }

    public User save(User user) {
        return userDAO.save(user);
    }

    public void delete(Long id) {
        userDAO.delete(id);
    }

    public User update(User user) {
        return userDAO.update(user);
    }
}
