package jquey.demo.controller;

import jquey.demo.sevices.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/show")
    public String show() {
        return "department";
    }

    @RequestMapping(value = "/saveDept")
    public @ResponseBody String saveDept(@RequestBody Map<String,String> map) {
        return departmentService.saveDepartment(map);
    }
}
