package jquey.demo.sevices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jquey.demo.models.Department;
import jquey.demo.models.Response;
import jquey.demo.repositories.DepartmentRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        Map<String,List<Department>> mp = new HashMap<String,List<Department>>();
//        mp.put("data",(List<Department>)departmentRepository.findAll());
        return (List<Department>) departmentRepository.findAll();
    }

//    public Map<String, String> getAllDept() {
//        Map<String, String> mp = new HashMap<String, String>();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "";
//        try {
//            json = objectMapper.writeValueAsString(departmentRepository.findAll()).toString();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        mp.put("data", json);
//        return mp;
//    }
}
