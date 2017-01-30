package ph.com.nikkinicholas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.com.nikkinicholas.domain.Student;
import ph.com.nikkinicholas.service.StudentService;

import java.util.List;

/**
 * Created by nikkiromero on 16/01/2017.
 */
@RestController
@RequestMapping(value = { "/students" })
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student selectOne(@PathVariable("id") String id) {
        return studentService.selectOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> selectAll() {
        return studentService.selectAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void delete(@RequestBody Student student) {
        studentService.delete(student);
    }
}
