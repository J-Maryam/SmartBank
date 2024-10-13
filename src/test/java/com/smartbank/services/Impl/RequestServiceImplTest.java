package com.smartbank.services.Impl;
import org.junit.jupiter.api.Test;

import com.smartbank.models.Request;
import com.smartbank.repositories.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class RequestServiceImplTest {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestServiceImpl requestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllRequests() {
        Request request1 = new Request(1L, "John", "Doe", "CIN123456", LocalDate.of(1990, 1, 1), LocalDate.of(2015, 6, 1), 5000.0, true, "john.doe@example.com", "0123456789", "monsieur", "type1", "Manager", 10000L, 12, new BigDecimal("500.00"));
        Request request2 = new Request(2L, "Jane", "Smith", "CIN654321", LocalDate.of(1985, 5, 15), LocalDate.of(2010, 2, 20), 7000.0, false, "jane.smith@example.com", "0987654321", "madame", "type2", "Analyst", 15000L, 24, new BigDecimal("600.00"));

        List<Request> mockRequest = Arrays.asList(request1, request2);

        when(requestRepository.findAll()).thenReturn(mockRequest);
        List<Request> requests = requestService.findAll();

        assertEquals(mockRequest.size(), requests.size());
        assertEquals(mockRequest.get(0).getFirstName(), requests.get(0).getFirstName());
        assertEquals(mockRequest.get(1).getFirstName(), requests.get(1).getFirstName());

    }

    @Test
    void testFindAll_WithEmptyList() {
        when(requestRepository.findAll()).thenReturn(Arrays.asList());
        List<Request> actualRequests = requestService.findAll();
        assertTrue(actualRequests.isEmpty());
    }

    @Test
    void testFindAll_WithNullValues() {
        Request request1 = new Request(1L, null, "Doe", "CIN123456", LocalDate.of(1990, 1, 1), LocalDate.of(2015, 6, 1), 5000.0, true, "john.doe@example.com", "0123456789", "monsieur", "type1", "Manager", 10000L, 12, new BigDecimal("500.00"));
        when(requestRepository.findAll()).thenReturn(List.of(request1));

        List<Request> actualRequests = requestService.findAll();
        assertEquals(1, actualRequests.size());
        assertNull(actualRequests.get(0).getFirstName());
        assertEquals("Doe", actualRequests.get(0).getLastName());
    }

    @Test
    void testFindAll_WithDuplicateRequests() {
        Request request1 = new Request(1L, "John", "Doe", "CIN123456", LocalDate.of(1990, 1, 1), LocalDate.of(2015, 6, 1), 5000.0, true, "john.doe@example.com", "0123456789", "monsieur", "type1", "Manager", 10000L, 12, new BigDecimal("500.00"));
        Request request2 = new Request(1L, "John", "Doe", "CIN123456", LocalDate.of(1990, 1, 1), LocalDate.of(2015, 6, 1), 5000.0, true, "john.doe@example.com", "0123456789", "monsieur", "type1", "Manager", 10000L, 12, new BigDecimal("500.00"));

        List<Request> mockRequest = Arrays.asList(request1, request2);
        when(requestRepository.findAll()).thenReturn(Arrays.asList(request1, request2));
        List<Request> actualRequests = requestService.findAll();

        assertEquals(mockRequest.size(), actualRequests.size());
        assertEquals(mockRequest.get(0).getFirstName(), actualRequests.get(0).getFirstName());
        assertEquals(mockRequest.get(1).getFirstName(), actualRequests.get(1).getFirstName());
    }

    @Test
    void testFindAll_DatabaseFailure() {
        doThrow(new RuntimeException("Database connection error")).when(requestRepository).findAll();

        assertThrows(RuntimeException.class, () -> {
            requestService.findAll();
        });
    }
}