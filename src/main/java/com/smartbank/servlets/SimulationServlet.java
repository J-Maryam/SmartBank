package com.smartbank.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/simulate")
public class SimulationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String projectType = request.getParameter("projectType");
        String position = request.getParameter("position");
        String amount = request.getParameter("amount");
        int durationsInMonths = Integer.parseInt(request.getParameter("durationsInMonths"));
        BigDecimal monthlyIncome = BigDecimal.valueOf(Double.parseDouble(request.getParameter("monthlyIncome")));

        HttpSession session = request.getSession();
        session.setAttribute("projectType", projectType);
        session.setAttribute("position", position);
        session.setAttribute("amount", amount);
        session.setAttribute("durationsInMonths", durationsInMonths);
        session.setAttribute("monthlyIncome", monthlyIncome);

        System.out.println("Type de projet: " + projectType);
        System.out.println("Position: " + position);
        System.out.println("Montant: " + amount);
        System.out.println("Durée en mois: " + durationsInMonths);
        System.out.println("Revenus mensuels: " + monthlyIncome);

        response.sendRedirect("step2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String projectType = (String) session.getAttribute("projectType");
        String position = (String) session.getAttribute("position");
        String amount = (String) session.getAttribute("amount");
        int durationsInMonths = (Integer) session.getAttribute("durationsInMonths");
        BigDecimal monthlyIncome = (BigDecimal) session.getAttribute("monthlyIncome");

        response.sendRedirect("step2.jsp");
    }
}
