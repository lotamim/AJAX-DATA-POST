package jquey.demo.controller;

import jquey.demo.models.Student;
import jquey.demo.sevices.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	@RequestMapping(value ="/getData/{id}")
	public Student getData(Model model, @PathVariable Long id){
		return (Student) model.addAttribute("studentObj",studentService.getStudent(id));
	}
}
