package ph.com.nikkinicholas.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ph.com.nikkinicholas.service.StudentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by nikkiromero on 30/01/2017.
 */
public class StudentControllerTest {
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(studentController)
                .build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(post("/students/findAll"));
    }
}
