package jquey.demo.sevices;

import jquey.demo.models.Student;
import jquey.demo.repositories.StudentRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public String saveStudent(Student student) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("message", studentRepository.save(student).getStudentName() + "Successfully ");
        } catch (JSONException e) {
            e.printStackTrace();
        }

//		 return studentRepository.save(student);
        return jsonObject.toString();
    }
}
