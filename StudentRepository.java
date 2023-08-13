package com.CRUDOperation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUDOperation.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> 
{
	Optional<Student> findByStudentId(long id);
}
