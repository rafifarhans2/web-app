package com.example.webapp.service;

import com.example.webapp.model.Student;
import com.example.webapp.model.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    public List<javax.xml.crypto.Data> getData(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("S1", "first", "Dep 1", 35));
        list.add(new Student("S2", "second", "Dep 1", 70));
        list.add(new Student("S3", "third", "Dep 1", 60));
        list.add(new Student("S4", "fourth", "Dep 1", 90));
        list.add(new Student("S5", "fifth", "Dep 2", 30));
        list.add(new Student("S6", "sixth", "Dep 3", 32));
        list.add(new Student("S7", "seventh", "Dep 3", 70));
        list.add(new Student("S8", "eighth", "Dep 3", 20));

        Map<String, List<Student>> students = new HashMap<>();
        for (Student student : list){
            String department = student.getDepartment();
            students.computeIfAbsent(department, k -> new ArrayList<>()).add(student);
        }

        Map<String, Double> percentages = new HashMap<>();
        for (String department : students.keySet()) {
            List<Student> filteredStudent = students.get(department).stream()
                    .filter(student -> student.getMarks() != null && (Integer) student.getMarks() >= 40)
                    .collect(Collectors.toList());
            int studentPass = filteredStudent.size();
            int departmentStudents = students.get(department).size();
            Double percentage = (double) (studentPass * 100 / departmentStudents);
            percentages.put(department, percentage);
        }

        List<javax.xml.crypto.Data> dataList = new ArrayList<>();
        for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
            Data data = new Data();
            String key = entry.getKey();
            data.setDepartment(key);
            List<String> studentId = new ArrayList<>();
            List<Integer> marks = new ArrayList<>();
            List<Student> studentsList = entry.getValue();
            for (Student student : studentsList) {
                studentId.add(student.getStudentId());
                marks.add(student.getMarks());
            }
            data.setStudentId(studentId);
            data.setMarks(marks);
            data.setPercentage(percentages.get(key));
            dataList.add(data);
        }
        dataList.sort(Comparator.comparing(Data::getDepartment));
        return dataList;
    }
}
