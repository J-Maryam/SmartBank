package com.smartbank.servlets;

import com.smartbank.models.Status;
import com.smartbank.repositories.Impl.StatusRepositoryImpl;
import com.smartbank.repositories.StatusRepository;
import com.smartbank.services.ServiceImpl.StatusServiceImpl;
import com.smartbank.services.StatusService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String status = req.getParameter("status");

        Status newStatus = new Status();
        newStatus.setStatus(status);

        StatusRepository statusRepository = new StatusRepositoryImpl();
        StatusService statusService = new StatusServiceImpl(statusRepository);

        try {
            statusService.save(newStatus);
            req.setAttribute("successMessage", "Votre statut a été soumise avec succès !");
        }catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
        }
    }
}
