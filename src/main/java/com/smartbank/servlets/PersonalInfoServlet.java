package com.smartbank.servlets;

import com.smartbank.models.Request;
import com.smartbank.models.Status;
import com.smartbank.repositories.Impl.RequestRepositoryImpl;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import com.smartbank.services.ServiceImpl.RequestServiceImpl;
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
public class PersonalInfoServlet extends HttpServlet {

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
        String hasActivateCreditsStr = request.getParameter("hasActivateCredits");
        boolean hasActivateCredits = Boolean.parseBoolean(hasActivateCreditsStr);

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

        RequestRepository requestRepository = new RequestRepositoryImpl();
        RequestService requestService = new RequestServiceImpl(requestRepository);

        try {
            requestService.save(newRequest);
            request.setAttribute("newRequest", newRequest);

            String statusStr = request.getParameter("status");
            Status newStatus = new Status();
            newStatus.setStatus(statusStr);


            request.setAttribute("successMessage", "Votre demande a été soumise avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Une erreur est survenue lors de la soumission de votre demande.");
        }

        request.getRequestDispatcher("step3.jsp").forward(request, response);
    }
}
