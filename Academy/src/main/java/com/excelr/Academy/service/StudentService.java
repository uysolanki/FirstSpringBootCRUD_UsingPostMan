package com.excelr.Academy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.Academy.entity.Student;
import com.excelr.Academy.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studrepo;
	public Student addStudent(Student student) {
		return studrepo.save(student);
	}
	public List<Student> getAllStudent() {
		return studrepo.findAll();
		
	}
	public Student getStudent(int rno) {
		Optional<Student> stud=studrepo.findById(rno);
		if(stud.isPresent())
			return stud.get();
		else
			return null;
		
		//return studrepo.findById(rno).get();
		
	}
	public List<Student> getStudent(String sname) {
		return studrepo.findBySname(sname);
	}
	public List<Student> getStudentByAge(int age) {
		return studrepo.findByAgeLessThan(age);
	}
	public void deleteStudent(int rno) {
		studrepo.deleteById(rno);
		
	}
	public void updateStudent(int rno, Student studuser) {
		Student studdb=getStudent(rno);
		studdb.setAge(studuser.getAge());
		studdb.setPer(studuser.getPer());
		studdb.setSname(studuser.getSname());
		studrepo.save(studdb);
	}

}
