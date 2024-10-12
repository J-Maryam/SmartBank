package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.models.RequestStatus;
import com.smartbank.models.Status;
import com.smartbank.services.RequestService;
import com.smartbank.services.RequestStatusService;
import com.smartbank.services.StatusService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@ApplicationScoped
@WebServlet("/updateStatus")
public class StatusServlet extends HttpServlet {

    @Inject
    RequestStatusService requestStatusService;

    @Inject
    StatusService statusService;

    @Inject
    RequestService requestService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Long requestId = Long.parseLong(req.getParameter("request_id"));
        Long statusId = Long.parseLong(req.getParameter("status"));
        String justification = req.getParameter("justification");

        RequestStatus requestStatus = new RequestStatus();

        Request request = requestService.findById(requestId);
        Status status = statusService.findById(statusId);

        requestStatus.setRequest(request);
        requestStatus.setStatus(status);
        requestStatus.setJustification(justification);
        requestStatus.setStatusDate(LocalDate.now());

        requestStatusService.save(requestStatus);
        res.sendRedirect(req.getContextPath() + "/requests");
    }
}
