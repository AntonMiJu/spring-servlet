package com.lesson7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {

    @RequestMapping(method = RequestMethod.GET, value = "/testMvc")
    public String testMvc(){
        return "home";
    }
}
