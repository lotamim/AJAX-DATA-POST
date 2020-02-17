package jquey.demo.sevices;

import jquey.demo.models.Department;
import jquey.demo.repositories.DepartmentRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public String saveDepartment(Map<String,String> mp) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        Department department = new Department();
        department.setDeptName(mp.get("deptName"));
        department.setMaxCapacity(mp.get("maxCapacity"));
        try {
            jsonObject.put("message", departmentRepository.save(department).getDeptName() + "Successfully ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
