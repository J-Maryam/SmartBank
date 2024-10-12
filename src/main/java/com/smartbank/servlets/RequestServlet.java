    package com.smartbank.servlets;

    import com.smartbank.models.Request;
    import com.smartbank.models.Status;
    import com.smartbank.repositories.Impl.RequestRepositoryImpl;
    import com.smartbank.repositories.RequestRepository;
    import com.smartbank.services.RequestService;
    import com.smartbank.services.ServiceImpl.RequestServiceImpl;
    import com.smartbank.services.StatusService;
    import jakarta.enterprise.context.ApplicationScoped;
    import jakarta.enterprise.context.RequestScoped;
    import jakarta.inject.Inject;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.io.IOException;
    import java.util.List;

    @WebServlet("/requests")
    @ApplicationScoped
    public class RequestServlet extends HttpServlet {

        @Inject
        private RequestService requestService;
        @Inject
        private StatusService statusService;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            List<Request> requestList = requestService.findAll();
            req.setAttribute("requestList", requestList);

            List<Status> statusList = statusService.findAll();
            req.setAttribute("statusList", statusList);
            req.getRequestDispatcher("requests.jsp").forward(req, resp);
        }
    }
