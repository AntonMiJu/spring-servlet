package com.lesson7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class MvcController {

    @RequestMapping(method = RequestMethod.GET, value = "/testMvc/{userId}")
    public CustomResponse testMvc(@RequestParam String name, @PathVariable String userId){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setId(1111L);
        return customResponse;
    }
}
