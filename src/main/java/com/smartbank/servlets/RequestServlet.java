package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.repositories.Impl.RequestRepositoryImpl;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import com.smartbank.services.ServiceImpl.RequestServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/requests")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestRepository requestRepository = new RequestRepositoryImpl();
        RequestService requestService = new RequestServiceImpl(requestRepository);

        List<Request> requestList = requestService.findAll();
        req.setAttribute("requestList", requestList);
        req.getRequestDispatcher("requests.jsp").forward(req, resp);
    }
}
