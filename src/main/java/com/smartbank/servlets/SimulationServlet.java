package com.smartbank.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/simulate")
public class SimulationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String projectType = request.getParameter("projectType");
            String position = request.getParameter("position");
            Long amount = Long.parseLong(request.getParameter("amount"));
            int durationsInMonths = Integer.parseInt(request.getParameter("durationsInMonths"));
            Double monthlyIncome = Double.parseDouble(request.getParameter("monthlyIncome"));

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
        }catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "Erreur de calcul des mensualités : " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("errorMessage", "Une erreur est survenue lors de la soumission de votre demande.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
