package jquey.demo.controller;

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

    @RequestMapping(value = "/saveEmployee")
    public @ResponseBody
    String saveEmployee(@RequestBody Map<String, String> empMap) {
        return employeeService.saveEmployee(empMap);
    }


    @RequestMapping(value = "/getAllEmployee")
    public @ResponseBody List<Map<String,String>> getAllEmployee (){
       return employeeService.getAllEmployeeList();
    }

    @RequestMapping(value = "/selectedEmp")
    public @ResponseBody String getEmployeeById(@RequestBody Map<String,String> empMap) {
        return employeeService.getEmployeeById(Integer.parseInt(empMap.get("empId")));
    }

}
