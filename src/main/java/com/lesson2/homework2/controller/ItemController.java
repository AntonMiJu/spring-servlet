package com.lesson2.homework2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson2.homework2.objects.Item;
import com.lesson2.homework2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/itemGet", produces = "text/plain")
    public @ResponseBody String get(HttpServletRequest req){
        return itemService.findById(Long.parseLong(req.getParameter("itemID"))).toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/itemSave", produces = "text/plain")
    public @ResponseBody String save(HttpServletRequest req) throws IOException {
        Item item = null;
        try (InputStream inputStream = req.getInputStream()) {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e) {
            System.err.println("DoPost failed.");
            System.err.println(e.getMessage());
            return null;
        }
        if (item==null)
            return null;
        return itemService.save(item).toString();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/itemUpdate", produces = "text/plain")
    public @ResponseBody String update(HttpServletRequest req) throws IOException{
        Item item = null;
        try (InputStream inputStream = req.getInputStream()) {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e) {
            System.err.println("DoPut failed.");
            System.err.println(e.getMessage());
            return null;
        }
        if (item==null)
            return null;
        return itemService.update(item).toString();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/itemDelete", produces = "text/plain")
    public @ResponseBody void delete(HttpServletRequest req){
        itemService.delete(Long.parseLong(req.getParameter("itemId")));
    }
}
