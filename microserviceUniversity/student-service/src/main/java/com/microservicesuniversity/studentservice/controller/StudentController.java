package com.microservicesuniversity.studentservice.controller;


import com.microservicesuniversity.studentservice.request.CreateStudentRequest;
import com.microservicesuniversity.studentservice.response.StudentResponse;
import com.microservicesuniversity.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	StudentService studentService;
	
	@PostMapping("/create")
	public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}
	
	@GetMapping("getById/{id}")
	public StudentResponse getById (@PathVariable long id) {
		return studentService.getById(id);
	}
	
}
