package com.smartbank;

import com.smartbank.models.Request;
import com.smartbank.repositories.Impl.RequestRepositoryImpl;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import com.smartbank.services.ServiceImpl.RequestServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RequestRepository requestRepository = new RequestRepositoryImpl();
        RequestService requestService = new RequestServiceImpl(requestRepository);

//        Request request = new Request();
//        request.setFirstName("Jonyr");
//        request.setLastName("Deep");
//        request.setCin("AB123456");
//        request.setBirthDate(LocalDate.of(1990, 1, 15));
//        request.setStartEmployementDate(LocalDate.of(2024, 1, 10));
//        request.setMonthlyIncome(4500.00);
//        request.setHasActivateCredits(false);
//        request.setEmail("john.doe@gmail.com");
//        request.setPhoneNumber("0647859621");
//        request.setType("Personal");
//        request.setPosition("Software Engineer");
//        request.setAmount("100000");
//        request.setDurationsInMonths(12);
//        request.setMonthlyPayment(new BigDecimal("850.50"));
//
//        requestService.save(request);
//
//        List<Request> requests = requestService.findAll();
//        if (requests.isEmpty()) {
//            System.out.println("No requests found");
//        }else {
//            System.out.println("List of requests:");
//            for (Request r : requests) {
//                System.out.println("\nId: " + r.getId() + "\nfirstname: " + r.getFirstName() + "\namount: " + r.getAmount() + "\nbirthDate: " + r.getBirthDate());
//            }
//        }

        Long requestId = 3L;
        Request foundRequest = requestService.findById(requestId);
        if (foundRequest != null) {
            System.out.println("first name : " + foundRequest.getFirstName() + "first name : " + foundRequest.getBirthDate());
        }else {
            System.out.println("Request not found");
        }
    }
}
