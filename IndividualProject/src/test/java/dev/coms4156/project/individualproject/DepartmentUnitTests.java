package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class for {@link Department}.
 * This class contains all unit tests that verify the functionality of the Department class
 * through various test cases designed to confirm both positive and expected failure behaviors.
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

    @BeforeEach
    public void setup() {
        HashMap<String, Course> courses = new HashMap<>();
        courses.put("CS999", new Course("Dr. White", "HAM 707", "9 AM - 10 AM", 30));
        testDepartment = new Department("CS", courses, "Dr. Black", 150);
    }

    @Test
    public void GetNumberOfMajorsTest() {
        assertEquals(150, testDepartment.getNumberOfMajors());
    }

    @Test
    public void GetDepartmentChairTest() {
        String chair = testDepartment.getDepartmentChair();
        assertEquals("Dr. Black", chair, "The department chair should be 'Dr. Black'");
    }

    @Test
    public void addPersonToMajorTest() {
        testDepartment.addPersonToMajor();
        assertEquals(151, testDepartment.getNumberOfMajors(), "Adding a person should increase the number of majors by one.");
    }


    @Test
    public void DropPersonFromMajorTest() {
        testDepartment.dropPersonFromMajor();
        assertEquals(149, testDepartment.getNumberOfMajors(), "Dropping a person should decrease the number of majors by one.");
    }

    @Test
    public void DropPersonFromMajorWhenNoneTest() {
        testDepartment = new Department("CS", new HashMap<>(), "Dr. Alice Smith", 0); // Set to zero
        testDepartment.dropPersonFromMajor();
        assertEquals(0, testDepartment.getNumberOfMajors(), "Dropping a person should not decrease the number of majors below zero.");
    }

    @Test
    public void AddCourseTest() {
        Course newCourse = new Course("Dr. Shen", "NWC 111", "10 AM - 11 AM", 25);
        testDepartment.addCourse("CS102", newCourse);
        assertTrue(testDepartment.getCourseSelection().containsKey("CS102"));
    }

    /** The test department instance used for testing. */
    public static Department testDepartment;
    
}
