package com.CRUDOperation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CRUDOperation.entities.Student;
import com.CRUDOperation.repository.StudentRepository;
@Service
public class StudentServicesImpl implements StudentService
{

	@Autowired
	private StudentRepository repository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public Student createOneStudent(Student student)
	{
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return repository.save(student);
	}


	@Override
	public List<Student> getAllRecords() 
	{
		
		return repository.findAll();
	}


	@Override
	public Student updateRecods(long id, Student student)
	{
		Student student1=repository.findById(id).get();
		student1.setName(student.getName());
		student1.setUsername(student.getUsername());
		student1.setPassword(student.getPassword());
		student1.setEmail(student.getEmail());
		student1.setMobile(student.getMobile());
		
		student1.setPassword(passwordEncoder.encode(student1.getPassword()));
		return repository.save(student1);
	}


	@Override
	public void deleteRecords(long id) 
	{
		repository.deleteById(id);
		
	}


	@Override
	public Student findById(long id)
	{
		Student s1=repository.findById(id).get();
		return s1;
	}
	
	
	

}
