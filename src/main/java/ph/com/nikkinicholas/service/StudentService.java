package ph.com.nikkinicholas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.com.nikkinicholas.domain.Student;
import ph.com.nikkinicholas.repository.StudentRepository;

import java.util.List;

/**
 * Created by nikkiromero on 16/01/2017.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student selectOne(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> selectAll() {
        return studentRepository.findAll();
    }

    public void create(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
