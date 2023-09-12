package com.ex.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ex.model.Student;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Component
public class StudentFetchRunner implements CommandLineRunner {
	//#1. Autowire EntityManagerFactory created in data JPA Environment
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public void run(String... args) throws Exception {
		//#2. Create CriteriaBuilder using EntityManagerFactory
		
		CriteriaBuilder cb=emf.getCriteriaBuilder();
		
		//select stdName form student where stdFee > ?
		//#3. Create Object for criteriaQuery by specifying result class type
		CriteriaQuery<String> cq=cb.createQuery(String.class);
		
		//#4. Provide from section (also called as root)
		Root<Student> root=cq.from(Student.class);
		
		//#5. Provide select section using method select()/multiselect
		cq.select(root.get("stdName"));
		
		//#6. Create where condition using builders and query
		cq.where(cb.gt(root.get("stdFee"), 2.2));
		
		//#7. Create executable query
		TypedQuery<String> query=emf.createEntityManager().createQuery(cq);
		
		//#8. Get result and print data
		List<String> list=query.getResultList();
		
		list.forEach(System.out::println);

	}

}
