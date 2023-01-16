import com.example.javapro.controller.*;
import com.example.javapro.pojo.*;
import com.example.javapro.service.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


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
