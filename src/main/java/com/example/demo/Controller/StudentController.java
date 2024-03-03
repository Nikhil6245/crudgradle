package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/addstudent")
	@ResponseBody
	public Student postdetails(@RequestBody Student student)

	{
		studentRepository.save(student);

		return student;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Student> getAllUsers() {
		// This returns a JSON or XML with the users
		return studentRepository.findAll();
	}

}
