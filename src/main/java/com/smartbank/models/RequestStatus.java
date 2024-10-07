package com.smartbank.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

public class RequestStatus implements Serializable {

    @ManyToMany
    private Request request;

    @ManyToMany
    private Status status;

    private LocalDate StatusDate;

    private String Justification;

    public RequestStatus() {}

    public RequestStatus(Request request, Status status, LocalDate StatusDate, String Justification) {
        this.request = request;
        this.status = status;
        this.StatusDate = StatusDate;
        this.Justification = Justification;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStatusDate() {
        return StatusDate;
    }

    public void setStatusDate(LocalDate statusDate) {
        StatusDate = statusDate;
    }

    public String getJustification() {
        return Justification;
    }

    public void setJustification(String justification) {
        Justification = justification;
    }
}
