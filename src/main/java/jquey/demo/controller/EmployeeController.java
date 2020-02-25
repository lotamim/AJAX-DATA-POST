package jquey.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class EmployeeController {
    @RequestMapping(value = "/showEmployee")
    public String show() {
        return "/employee/create";
    }
}
