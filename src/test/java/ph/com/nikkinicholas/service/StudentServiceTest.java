package ph.com.nikkinicholas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ph.com.nikkinicholas.domain.Student;
import ph.com.nikkinicholas.repository.StudentRepository;

import java.util.ArrayList;

/**
 * Created by nikkiromero on 30/01/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
    @InjectMocks
    private StudentService studentService = new StudentService();

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testFindOne() {
        final String id = "1";
        studentService.findOne(id);
        Mockito.verify(studentRepository, Mockito.times(1)).findOne(id);
    }

    @Test
    public void testFindAll() {
        Mockito.when(studentRepository.findAll()).thenReturn(new ArrayList<>());
        studentService.findAll();
        Mockito.verify(studentRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testCreate() {
        Student student = Mockito.mock(Student.class);
        studentService.create(student);
        Mockito.verify(student, Mockito.times(1)).setId(Mockito.anyString());
        Mockito.verify(studentRepository, Mockito.times(1)).save(student);
    }

    @Test
    public void testUpdate() {
        Student student = Mockito.mock(Student.class);
        studentService.update(student);
        Mockito.verify(student, Mockito.never()).setId(Mockito.anyString());
        Mockito.verify(studentRepository, Mockito.times(1)).save(student);
    }

    @Test
    public void testDelete() {
        Student student = Mockito.mock(Student.class);
        studentService.delete(student);
        Mockito.verify(student, Mockito.never()).setId(Mockito.anyString());
        Mockito.verify(studentRepository, Mockito.times(1)).delete(student);
    }
}
