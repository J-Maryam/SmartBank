package com.smartbank.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/coordonnees")
public class CoordinationsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNumber");

        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("phoneNumber", phone);

        System.out.println("email: " + email);
        System.out.println("phone: " + phone);

        response.sendRedirect("step3.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phoneNumber");

        response.sendRedirect("step3.jsp");
    }
}
