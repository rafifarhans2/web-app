package com.example.webapp.controller;

import com.example.webapp.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = ("/login"), name = "LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final LoginService loginService;

    public LoginController() {
        this.loginService = new LoginService();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        boolean login = loginService.isLogin(userID, password);
        if (login) {
            HttpSession session = request.getSession();
            session.setAttribute("nama", "Aul");
            response.sendRedirect("student");
        } else {
            response.sendRedirect("Login.jsp?error=true");
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
