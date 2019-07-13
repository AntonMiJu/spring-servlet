package com.lesson7.homework.controller;

import com.lesson7.homework.exceptions.LoginException;
import com.lesson7.homework.models.Filter;
import com.lesson7.homework.models.Post;
import com.lesson7.homework.models.User;
import com.lesson7.homework.service.PostService;
import com.lesson7.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FindMeController {
    private static User currentUser;

    private UserService userService;
    private PostService postService;

    @Autowired
    public FindMeController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findme/login")
    @ResponseBody
    public String login(@RequestParam String name, @RequestParam String password) throws LoginException {
        if (currentUser != null)
            throw new LoginException("User " + currentUser.getId() + " is already logined in service.");
        User user = userService.getByName(name);
        if (user.getPassword().equals(password)) {
            currentUser = user;
            return "Login completed";
        }
        return "400: Password or username is incorrect.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/findme/logout")
    @ResponseBody
    public String logout() {
        currentUser = null;
        return "You are logout.";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findme/register")
    @ResponseBody
    public String register(@RequestBody User userToRegister) {
        if (userToRegister == null)
            return "400: Can't find currentUser, please, write currentUser data";
        if (userService.getByName(userToRegister.getName()) != null)
            return "400: User with this username is already exist.";
        userService.save(userToRegister);
        return "Registration completed successfully.";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findme/savePost")
    @ResponseBody
    public String savePost(@RequestBody Post post) throws LoginException {
        validateLogin();
        if (post == null)
            return "400: Can't find post, please, write post data";
        postService.save(post);
        return "Saving completed.";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/findme/editPost")
    @ResponseBody
    public String editPost(@RequestBody Post post) throws LoginException {
        validateLogin();
        if (!currentUser.getPosts().contains(post))
            return "400: You can edit only your posts.";
        postService.update(post);
        return "Update completed.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/findme/deletePost")
    @ResponseBody
    public String deletePost(@RequestParam Long id) throws LoginException{
        validateLogin();
        if (!currentUser.getPosts().contains(postService.get(id)))
            return "400: You can delete only your posts.";
        postService.delete(id);
        return "Delete completed";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findme/getPosts")
    @ResponseBody
    public String getPostsByFilterOrDefault(@RequestBody Filter filter) {
        if (filter == null)
            return postService.getAllAvailablePosts().toString();
        return postService.getPostsByFilter(filter).toString();
    }

    private void validateLogin() throws LoginException {
        if (currentUser == null)
            throw new LoginException("You must be logined");
    }
}
