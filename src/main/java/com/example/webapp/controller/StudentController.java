package com.example.webapp.controller;

import com.example.webapp.service.StudentService;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/student", name = "StudentController")
public class StudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final StudentService studentService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nama = (String) session.getAttribute("nama");

        if (nama != null) {
            request.setAttribute("nama", nama);

            String json = new Gson().toJson(studentService.getData());

            request.setAttribute("dataList", json);

            RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
