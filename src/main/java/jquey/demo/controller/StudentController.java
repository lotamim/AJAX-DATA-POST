package jquey.demo.controller;

import jquey.demo.models.Student;
import jquey.demo.sevices.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students",students);
		return "students";
//		return studentService.getAll();
	}
	
	@RequestMapping(value = "/saveStudent",method =RequestMethod.POST)
	public @ResponseBody String saveStudent(@RequestBody Student student,Model model) {
		return studentService.saveStudent(student);
//		model.addAttribute(studentService.saveStudent(student));
//		return "redirect:/getAll";
	}
}
