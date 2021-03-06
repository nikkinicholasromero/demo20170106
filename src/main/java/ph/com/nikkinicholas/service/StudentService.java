package ph.com.nikkinicholas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.com.nikkinicholas.domain.Student;
import ph.com.nikkinicholas.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by nikkiromero on 16/01/2017.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findOne(String id) {
        return studentRepository.findOne(id);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void create(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentRepository.save(student);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
