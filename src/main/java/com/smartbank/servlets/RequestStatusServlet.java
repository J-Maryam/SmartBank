package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.models.RequestStatus;
import com.smartbank.models.Status;
import com.smartbank.repositories.Impl.RequestStatusRepositoryImpl;
import com.smartbank.repositories.RequestStatusRepository;
import com.smartbank.services.RequestStatusService;
import com.smartbank.services.ServiceImpl.RequestStatusServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

public class RequestStatusServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Request request = (Request) req.getAttribute("request");
        Status status = (Status) req.getAttribute("status");
        String justification = req.getParameter("justification");

        RequestStatus requestStatus = new RequestStatus();
        requestStatus.setRequest(request);
        requestStatus.setStatus(status);
        requestStatus.setStatusDate(LocalDate.now());
        requestStatus.setJustification(justification);

        RequestStatusRepository requestStatusRepository = new RequestStatusRepositoryImpl();
        RequestStatusService requestStatusService = new RequestStatusServiceImpl(requestStatusRepository);

        try {
            requestStatusService.save(requestStatus);
            req.setAttribute("successMessage", "Le statut de la demande a été enregistré avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Une erreur est survenue lors de l'enregistrement du statut de la demande.");
        }
    }
}
