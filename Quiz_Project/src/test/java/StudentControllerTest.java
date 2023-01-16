import com.example.Quiz_Project.controller.*;
import com.example.Quiz_Project.pojo.*;
import com.example.Quiz_Project.service.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("John Doe");
        student.setId(2L);

        assertEquals(2l, student.getId());
        assertEquals("John Doe",student.getName());
    }
/*
    @Test
    public void testGetStudentById() {
        Student student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        when(studentService.getStudentById(1L)).thenReturn(student);
        Student response = studentController.findById(1L);
        assertEquals(1L, response.getId());
        assertEquals("John Doe", response.getName());
    }*/

}
