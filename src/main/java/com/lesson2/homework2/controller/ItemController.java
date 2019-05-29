package com.lesson2.homework2.controller;

import com.lesson2.homework2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET, value = "/itemGet", produces = "text/plain")
    public @ResponseBody String get(){
        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/itemSave", produces = "text/plain")
    public @ResponseBody String save(){
        return "ok";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/itemUpdate", produces = "text/plain")
    public @ResponseBody String update(){
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/itemDelete", produces = "text/plain")
    public @ResponseBody String delete(){
        return "ok";
    }
}
