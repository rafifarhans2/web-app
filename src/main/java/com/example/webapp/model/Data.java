package com.example.webapp.model;

import java.util.List;

public class Data implements javax.xml.crypto.Data {
    private static String department;
    private List<String> studentId;
    private List<Integer> marks;
    private Double percentage;

    public static String getDepartment(javax.xml.crypto.Data t) {
        return department;
    }

    public void setDepartment(String department) {
        Data.department = department;
    }

    public List<String> getStudentId() {
        return studentId;
    }

    public void setStudentId(List<String> studentId) {
        this.studentId = studentId;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
