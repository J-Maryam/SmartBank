package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.models.Status;
import com.smartbank.services.RequestService;
import com.smartbank.services.StatusService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/filterRequests")
public class RequestFilterServlet extends HttpServlet {

    @Inject
    private RequestService requestService;

    @Inject
    private StatusService statusService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String dateParam = req.getParameter("date");
        String statusParam = req.getParameter("statusId");

        LocalDate date = LocalDate.parse(dateParam);
        Long status = Long.parseLong(statusParam);

        List<Request> filterRequests = requestService.filterRequests(date, status);

        List<Request> requestList = requestService.findAll();
        req.setAttribute("requestList", requestList);
        List<Status> statusList = statusService.findAll();
        req.setAttribute("statusList", statusList);

        req.setAttribute("filterRequests", filterRequests);
        req.getRequestDispatcher("filterRequests.jsp").forward(req, res);
    }
}
