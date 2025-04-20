package org.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;

public class StudentCourseController {

    @FXML private TextField txtStudentId;
    @FXML private TextField txtCourseCode;
    @FXML private TextField txtGrade;
    @FXML private ListView<String> listViewResults;

    private final Map<String, StudentNode> students = new HashMap<>();
    private final Map<String, CourseNode> courses = new HashMap<>();

    static class StudentNode {
        String studentId;
        CourseRecord courseHead;

        StudentNode(String studentId) {
            this.studentId = studentId;
        }
    }

    static class CourseNode {
        String courseCode;
        StudentRecord studentHead;

        CourseNode(String courseCode) {
            this.courseCode = courseCode;
        }
    }

    static class CourseRecord {
        String courseCode;
        String grade;
        CourseRecord nextCourse;

        CourseRecord(String courseCode, String grade) {
            this.courseCode = courseCode;
            this.grade = grade;
        }
    }

    static class StudentRecord {
        String studentId;
        String grade;
        StudentRecord nextStudent;

        StudentRecord(String studentId, String grade) {
            this.studentId = studentId;
            this.grade = grade;
        }
    }

    @FXML
    private void addCourseToStudent() {
        String studentId = txtStudentId.getText();
        String courseCode = txtCourseCode.getText();
        String grade = txtGrade.getText();

        if (!students.containsKey(studentId)) {
            students.put(studentId, new StudentNode(studentId));
        }

        StudentNode student = students.get(studentId);
        CourseRecord newCourse = new CourseRecord(courseCode, grade);
        newCourse.nextCourse = student.courseHead;
        student.courseHead = newCourse;

        listViewResults.getItems().add("Öğrenciye ders eklendi: " + studentId + " - " + courseCode);
    }

    @FXML
    private void addStudentToCourse() {
        String studentId = txtStudentId.getText();
        String courseCode = txtCourseCode.getText();
        String grade = txtGrade.getText();

        if (!courses.containsKey(courseCode)) {
            courses.put(courseCode, new CourseNode(courseCode));
        }

        CourseNode course = courses.get(courseCode);
        StudentRecord newStudent = new StudentRecord(studentId, grade);
        newStudent.nextStudent = course.studentHead;
        course.studentHead = newStudent;

        listViewResults.getItems().add("Derse öğrenci eklendi: " + courseCode + " - " + studentId);
    }

    @FXML
    private void removeCourseFromStudent() {
        String studentId = txtStudentId.getText();
        String courseCode = txtCourseCode.getText();

        if (!students.containsKey(studentId)) return;
        StudentNode student = students.get(studentId);

        CourseRecord prev = null, current = student.courseHead;
        while (current != null) {
            if (current.courseCode.equals(courseCode)) {
                if (prev == null) student.courseHead = current.nextCourse;
                else prev.nextCourse = current.nextCourse;
                listViewResults.getItems().add("Öğrencinin dersi silindi: " + studentId + " - " + courseCode);
                return;
            }
            prev = current;
            current = current.nextCourse;
        }
    }

    @FXML
    private void removeStudentFromCourse() {
        String studentId = txtStudentId.getText();
        String courseCode = txtCourseCode.getText();

        if (!courses.containsKey(courseCode)) return;
        CourseNode course = courses.get(courseCode);

        StudentRecord prev = null, current = course.studentHead;
        while (current != null) {
            if (current.studentId.equals(studentId)) {
                if (prev == null) course.studentHead = current.nextStudent;
                else prev.nextStudent = current.nextStudent;
                listViewResults.getItems().add("Ders içinden öğrenci silindi: " + courseCode + " - " + studentId);
                return;
            }
            prev = current;
            current = current.nextStudent;
        }
    }

    @FXML
    private void listStudentsByCourse() {
        String courseCode = txtCourseCode.getText();
        listViewResults.getItems().clear();

        if (!courses.containsKey(courseCode)) return;
        CourseNode course = courses.get(courseCode);

        List<String> studentList = new ArrayList<>();
        StudentRecord current = course.studentHead;
        while (current != null) {
            studentList.add(current.studentId + " (" + current.grade + ")");
            current = current.nextStudent;
        }

        Collections.sort(studentList);
        listViewResults.getItems().addAll(studentList);
    }

    @FXML
    private void listCoursesByStudent() {
        String studentId = txtStudentId.getText();
        listViewResults.getItems().clear();

        if (!students.containsKey(studentId)) return;
        StudentNode student = students.get(studentId);

        List<String> courseList = new ArrayList<>();
        CourseRecord current = student.courseHead;
        while (current != null) {
            courseList.add(current.courseCode + " (" + current.grade + ")");
            current = current.nextCourse;
        }

        Collections.sort(courseList);
        listViewResults.getItems().addAll(courseList);
    }
}
