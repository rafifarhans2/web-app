package com.example.webapp.model;

public class Student {
    private String studentId;
    private String studentName;
    private String department;
    private Integer marks;

    public Student(String studentId, String studentName, String department, Integer marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
