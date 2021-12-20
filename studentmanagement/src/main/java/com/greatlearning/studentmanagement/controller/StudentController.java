package com.greatlearning.studentmanagement.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;


@Controller
//add mapping for "/students"
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		//Optional<Student> student = new Student();
		Optional<Student> student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "Student-form";

	}
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String first_Name,
			@RequestParam("lastName") String last_Name, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		System.out.println(id);
		Student student = null;

		if (id != 0) {
			student.setFirstName(first_Name);
			student.setLastName(last_Name);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(id, first_Name, last_Name, course, country);

		}
		studentService.save(student);
		return "redirect:/student/list";

	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.deleteById(id);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
	