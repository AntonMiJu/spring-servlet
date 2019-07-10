package com.lesson5.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@Controller
public class ItemController {
    private ItemDAO itemDAO;
    private ObjectMapper objectMapper;

    @Autowired
    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item/save", produces = "text/plain")
    public @ResponseBody String save(HttpServletRequest req){
        Item item;
        try(InputStream inputStream = req.getInputStream()) {
            item = objectMapper.readValue(inputStream,Item.class);
        } catch (Exception e){
            System.err.println("DoPost failed.");
            return "400: "+e.getMessage();
        }
        if (item == null)
            return "400: Can't find item.";
        itemDAO.save(item);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/delete", produces = "text/plain")
    public @ResponseBody String delete(HttpServletRequest req){
        itemDAO.delete(Long.parseLong(req.getParameter("id")));
        return "ok";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item/update", produces = "text/plain")
    public @ResponseBody String update(HttpServletRequest req){
        Item item;
        try(InputStream inputStream = req.getInputStream()) {
            item = objectMapper.readValue(inputStream,Item.class);
        } catch (Exception e){
            System.err.println("DoPut failed.");
            return "400: "+e.getMessage();
        }
        if (item == null)
            return "400: Can't find item.";
        itemDAO.update(item);
        return "ok";
    }
}
