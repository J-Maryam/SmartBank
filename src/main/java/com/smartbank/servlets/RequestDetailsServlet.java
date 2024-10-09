package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.repositories.Impl.RequestRepositoryImpl;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import com.smartbank.services.ServiceImpl.RequestServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@RequestScoped
public class RequestDetailsServlet extends HttpServlet {

    @Inject
    private RequestService requestService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Request> requestList = requestService.findAll();
        req.setAttribute("requestList", requestList);
        req.getRequestDispatcher("requests.jsp").forward(req, resp);
    }
}
