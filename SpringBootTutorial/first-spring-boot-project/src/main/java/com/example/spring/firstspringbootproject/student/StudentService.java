package com.example.spring.firstspringbootproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudnets() {
//        return List.of( new Student(1L, "Sean", "seanhuang@mail.com", LocalDate.of(1992, 9, 30), 28));
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        //System.out.println(student.toString());
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student with id " + studentId + "does not exists");
        }
        System.out.println(studentId.toString());
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student id " + studentId + "does not exists"));

        //check the name length {
        if(name != null && name.length()>0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        } else if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
    }
}
