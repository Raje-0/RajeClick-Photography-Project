package com.raje.RestService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raje.restEntity.Student;
import com.raje.restRespository.StudentDao;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	public Student saveStudent(Student student) {
        return studentDao.save(student);
    }
	public void deleteStudent(Long id) {
		studentDao.deleteById(id);
    }

}
