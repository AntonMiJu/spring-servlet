package com.lesson6;

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
    private ItemService itemService;
    private ObjectMapper objectMapper;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/item/get", produces = "text/plain")
    public @ResponseBody String get(HttpServletRequest req){
        return itemService.get(Long.parseLong(req.getParameter("id"))).toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item/save", produces = "text/plain")
    public @ResponseBody String save(HttpServletRequest req){
        Item item;
        try(InputStream inputStream = req.getInputStream()) {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e){
            System.err.println("DoPost failed.");
            return "400: "+e.getMessage();
        }
        if (item == null)
            return "400: Can't find item";
        itemService.save(item);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/delete", produces = "text/plain")
    public @ResponseBody String delete(HttpServletRequest req){
        itemService.delete(Long.parseLong(req.getParameter("id")));
        return "ok";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item/update", produces = "text/plain")
    public @ResponseBody String update(HttpServletRequest req){
        Item item;
        try(InputStream inputStream = req.getInputStream()) {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e){
            System.err.println("DoPut failed.");
            return "400: "+e.getMessage();
        }
        if (item == null)
            return "400: Can't find item";
        itemService.update(item);
        return "ok";
    }
}
