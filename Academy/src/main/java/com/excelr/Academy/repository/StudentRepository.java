package com.excelr.Academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.Academy.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public  List<Student> findBySname(String sname);
	
	public  List<Student> findByAgeLessThan(int x);

}
