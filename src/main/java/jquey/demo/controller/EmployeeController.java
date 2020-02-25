package jquey.demo.controller;

import jquey.demo.models.Department;
import jquey.demo.sevices.DepartmentService;
import jquey.demo.sevices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/showEmployee")
    public String showEmployee() {
        return "/employee/create";
    }

    @RequestMapping(value = "/getDeptListForDrop")
    public @ResponseBody List<Department> getDeptListForDrop() {
        return employeeService.findAllDeptForDrop();
    }

    @RequestMapping(value = "/saveEmployee")
    public @ResponseBody
    String saveEmployee(@RequestBody Map<String, String> empMap) {
        return employeeService.saveEmployee(empMap);
    }
}
