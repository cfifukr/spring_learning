package com.example;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception{
		/*
		Student student1 = new Student("User", "Test1", "prosto");
		Student student2 = new Student("User", "Test2", "ne prosto");
		studentRepository.save(student1);
		studentRepository.save(student2);
		*/

	}
}
