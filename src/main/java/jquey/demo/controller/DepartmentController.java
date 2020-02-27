package jquey.demo.controller;

import jquey.demo.models.Department;
import jquey.demo.sevices.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/show")
    public String show() {
        return "/department/create";
    }

    @RequestMapping(value = "/saveDept")
    public @ResponseBody String saveDept(@RequestBody Map<String, String> map) {
        return departmentService.saveDepartment(map);
    }

    @RequestMapping(value = "/getList")
    public @ResponseBody List<Department> getList() {
        return departmentService.getAllDept();
    }

    @RequestMapping(value = "/select")
    public @ResponseBody Optional<Department> select(@RequestBody Map<String, String> map) {
        return departmentService.selectedDept(Integer.parseInt(map.get("id")));
    }

    @RequestMapping(value = "/updateDept")
    public @ResponseBody String updateDept(@RequestBody Map<String, String> map){
       return departmentService.updateDepartment(map);
    }

}