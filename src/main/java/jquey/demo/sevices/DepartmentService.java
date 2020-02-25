package jquey.demo.sevices;

import jquey.demo.models.Department;
import jquey.demo.repositories.DepartmentRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public String saveDepartment(Map<String, String> mp) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        Department department = new Department();
        department.setDeptName(mp.get("deptName"));
        department.setMaxCapacity(mp.get("maxCapacity"));
        try {
            jsonObject.put("message", departmentRepository.save(department).getDeptName() + " " + " Successfully ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public List<Department> getAllDept(){
        return (List<Department>) departmentRepository.findAll();
    }

    public Optional<Department> selectedDept(Integer id){
       return departmentRepository.findById(id);
    }

    public String updateDepartment(Map<String, String> mp) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        Department department = departmentRepository.findById(Integer.parseInt(mp.get("deptId"))).get();
        department.setDeptName(mp.get("deptName"));
        department.setMaxCapacity(mp.get("maxCapacity"));
        try {
            jsonObject.put("message", departmentRepository.save(department).getDeptName() + " " + " Successfully ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
