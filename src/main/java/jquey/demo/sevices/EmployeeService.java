package jquey.demo.sevices;

import jquey.demo.models.Department;
import jquey.demo.models.Employee;
import jquey.demo.repositories.DepartmentRepository;
import jquey.demo.repositories.EmployeeRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> findAllDeptForDrop() {
        return (List<Department>) departmentRepository.findAll();
    }

    public String saveEmployee(Map<String, String> empMap) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        Department department = departmentRepository.findById(Integer.parseInt(empMap.get("department"))).get();
        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setEmpFirstName(empMap.get("empFirstName"));
        employee.setEmpLastName(empMap.get("empLastName"));
        try {
            jsonObject.put("message", employeeRepository.save(employee).getEmpFirstName() + " " + " Successfully ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public List<Map<String,String>> getAllEmployeeList() {
        return employeeRepository.getEmployeeAll();
    }
    public String getEmployeeById(int empId){
        JSONObject jsonObject = new JSONObject();
        try {
              jsonObject.put("empData",employeeRepository.getEmployeeById(empId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
