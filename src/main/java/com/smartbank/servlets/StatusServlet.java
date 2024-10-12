package com.smartbank.servlets;

import com.smartbank.models.Status;
import com.smartbank.services.StatusService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ApplicationScoped
public class StatusServlet extends HttpServlet {

    @Inject
    StatusService statusService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String status = req.getParameter("status");

        Status newStatus = new Status();
        newStatus.setStatus(status);

        try {
            statusService.save(newStatus);
            req.setAttribute("successMessage", "Votre statut a été soumise avec succès !");
        }catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
        }
    }
}
