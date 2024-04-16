package com.excelr.Academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.Academy.entity.Student;
import com.excelr.Academy.service.StudentService;

//	http://localhost:8084/greet
@RestController
public class AcademicController {
	
//	@Value("${developer.name}")
//	String developername;
	
	@Autowired
	StudentService studservice;

	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to my Application";
	}
	
	@GetMapping("/greet")
	public String greet()
	{
		return "Welcome to Excelr Career Assurance Program";
	}
	
	@GetMapping("/virat")
	public String virat(ModelMap model)
	{
		model.addAttribute("captian", "Faf");
		model.addAttribute("coach", "Alice");
		model.addAttribute("owner", "Ben");
		return "virat";
	}
	
	@PostMapping("/addStudentWithRequestParam")
	public Student addStudentWithRequestParam(@RequestParam("sname") String sname,@RequestParam("age") int age,@RequestParam("gender") char gender,@RequestParam("per") double per)
	{
		Student s=null;
		Student student=new Student();
		student.setAge(age);
		student.setGender(gender);
		student.setPer(per);
		student.setSname(sname);
		try
		{
		s=studservice.addStudent(student);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	
	@PostMapping("/addStudentWithRequestBody")
	public Student addStudentWithRequestBody(@RequestBody Student student)
	{
		Student s=null;
		try
		{
		s=studservice.addStudent(student);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	@PostMapping("/addStudentWithPathVariable/{snamepv}/{agepv}/{genderpv}/{perpv}")
	public Student addStudentWithPathVariable(@PathVariable("snamepv") String sname,@PathVariable("agepv") int age,@PathVariable("genderpv") char gender,@PathVariable("perpv") double per)
	{
		Student s=null;
		Student student=new Student();
		student.setAge(age);
		student.setGender(gender);
		student.setPer(per);
		student.setSname(sname);
		try
		{
		s=studservice.addStudent(student);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent()
	{
		return studservice.getAllStudent();
	}
	
	@GetMapping("/getStudent")
	public Student getStudent(@RequestParam("rno") int rno)
	{
		return studservice.getStudent(rno);
	}
	
	@GetMapping("/getStudentByName")
	public List<Student> getStudentByName(@RequestParam("sname") String sname)
	{
		return studservice.getStudent(sname);
	}
	
	@GetMapping("/getStudentByAgeLessThan")
	public List<Student> getStudentByAgeLessThan(@RequestParam("age") int age)
	{
		return studservice.getStudentByAge(age);
	}
	
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("rno") int rno)
	{
		studservice.deleteStudent(rno);
		return "Student Record Deleted";
	}
	
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestParam("rno") int rno, @RequestBody Student studuser)
	{
		studservice.updateStudent(rno,studuser);
		return "Student Record Updated";
	}
}
