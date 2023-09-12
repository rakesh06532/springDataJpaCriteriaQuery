package com.ex.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ex.model.Student;
import com.ex.repo.StudentRepository;

@Component
public class StudentTestRunner implements CommandLineRunner {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {
	repo.save(new Student(10,"Rakesh",3.3,"Java"));
	repo.save(new Student(11,"Kuldeep",2.3,"Java"));
	repo.save(new Student(12,"Sandeep",3.5,"PHP"));
	repo.save(new Student(13,"Aryan",4.3,"HTML"));
	repo.save(new Student(14,"Rajesh",6.4,"Spring"));

	}

}
