package com.smartbank;

import com.smartbank.models.Request;
import com.smartbank.repositories.Impl.RequestRepositoryImpl;
import com.smartbank.repositories.RequestRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RequestRepository requestRepository = new RequestRepositoryImpl();

        Request request = new Request();
        request.setId(1L);
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setCin("AB123456");
        request.setBirthDate(LocalDate.of(2000, 5, 20));
        request.setStartEmployementDate(LocalDate.of(2024, 1, 10));
        request.setMonthlyIncome(3500.00);
        request.setEmail("john.doe@gmail.com");
        request.setPhoneNumber("0123456789");

        requestRepository.save(request);
    }
}
