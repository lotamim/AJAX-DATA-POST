package jquey.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
    @RequestMapping(value = "/show")
    public String show(){
        return "department";
    }
}
