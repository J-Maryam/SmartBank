package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.models.RequestStatus;
import com.smartbank.models.Status;
import com.smartbank.repositories.Impl.RequestRepositoryImpl;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import com.smartbank.services.RequestStatusService;
import com.smartbank.services.ServiceImpl.RequestServiceImpl;
import com.smartbank.services.ServiceImpl.RequestStatusServiceImpl;
import com.smartbank.services.StatusService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/personalInfo")
@ApplicationScoped
public class PersonalInfoServlet extends HttpServlet {

    @Inject
    private RequestService requestService;
    @Inject
    private StatusService statusService;
    @Inject
    private RequestStatusService requestStatusService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String projectType = (String) session.getAttribute("projectType");
        String position = (String) session.getAttribute("position");
        String amount = (String) session.getAttribute("amount");
        int durationInMonths = (Integer) session.getAttribute("durationsInMonths");
        Double monthlyIncome = (Double) session.getAttribute("monthlyIncome");
        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phoneNumber");
        String civility = request.getParameter("civility");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String cin = request.getParameter("cin");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String birthDateStr = request.getParameter("birthDate");
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
        String startEmployementDateStr = request.getParameter("startEmployementDate");
        LocalDate startEmployementDate = LocalDate.parse(startEmployementDateStr, formatter);
        String monthlyPaymentStr = request.getParameter("monthlyPayment");
        BigDecimal monthlyPayment = new BigDecimal(monthlyPaymentStr);
        boolean hasActivateCredits = Boolean.parseBoolean(request.getParameter("hasActivateCredits"));

        System.out.println("Civility: " + civility);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("CIN: " + cin);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Start Employment Date: " + startEmployementDate);
        System.out.println("Monthly Payment: " + monthlyPayment);
        System.out.println("Has Activate Credits: " + hasActivateCredits);


        Request newRequest = new Request();
        newRequest.setType(projectType);
        newRequest.setPosition(position);
        newRequest.setAmount(amount);
        newRequest.setDurationsInMonths(durationInMonths);
        newRequest.setMonthlyIncome(monthlyIncome);
        newRequest.setEmail(email);
        newRequest.setPhoneNumber(phone);
        newRequest.setCivility(civility);
        newRequest.setFirstName(firstName);
        newRequest.setLastName(lastName);
        newRequest.setCin(cin);
        newRequest.setBirthDate(birthDate);
        newRequest.setStartEmployementDate(startEmployementDate);
        newRequest.setMonthlyPayment(monthlyPayment);
        newRequest.setHasActivateCredits(hasActivateCredits);

        try {
            requestService.save(newRequest);
            Status status = statusService.findByStatus("En attente");
            if (status == null) {
                throw new ServletException("Status not found");
            }

            RequestStatus requestStatus = new RequestStatus();
            requestStatus.setRequest(newRequest);
            requestStatus.setStatus(status);
            requestStatus.setStatusDate(LocalDate.now());
            requestStatus.setJustification("Demande en attente de traitement.");

            requestStatusService.save(requestStatus);
            newRequest.getRequestStatuses().add(requestStatus);

            request.setAttribute("successMessage", "Votre demande a été soumise avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Une erreur est survenue lors de la soumission de votre demande.");
        }

        request.getRequestDispatcher("step3.jsp").forward(request, response);
    }
}