package com.smartbank.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//public class Request implements Serializable {
public class Request  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le prénom ne peut pas être vide ou composé uniquement d'espaces")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String firstName;

    @NotBlank(message = "Le prénom ne peut pas être vide ou composé uniquement d'espaces")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String lastName;

    @NotBlank(message = "CIN ne peut pas être vide ou composé uniquement d'espaces")
    private String cin;

    @Past(message = "BirthDate doit être au passé")
    private LocalDate birthDate;

    @PastOrPresent(message = "StartEmployementDate doit être au passé ou au présent")
    private LocalDate startEmployementDate;

    @NotNull(message = "Montant ne doit pas être null")
    @Positive(message = "Le montant doit être positive")
    private Double monthlyIncome;

    private boolean hasActivateCredits;

    @Email(message = "Email doit être valide")
    @NotBlank(message = "Email ne doit etre vide ou composé uniquement d'espaces")
    private String email;

    @NotNull(message = "Telephone ne doit pas être null")
    @Pattern(regexp = "0[1-9][0-9]{8}", message = "Le numéro de téléphone doit commencer par '0' suivi de 9 autres chiffres")
    private String phoneNumber;

    @Pattern(regexp = "monsieur|madame|mademoiselle", message = "La civilité doit être 'monsieur', 'madame' ou 'mademoiselle'")
    private String civility;

    @NotBlank(message = "Type est obligatoire")
    private String type;

    private String position;

    @NotNull(message = "Montant doit pas être null")
    @Positive(message = "Le montant doit être positive")
    private String amount;

    @Min(value = 12, message = "Duration must be at least 12 month")
    @NotNull(message = "DurationsInMonths ne doit pas être null")
    private int durationsInMonths;

    @NotNull(message = "Monthly payment ne doit pas être null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Monthly payment doit être superieure à 0")
    private BigDecimal monthlyPayment;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<RequestStatus> requestStatuses = new ArrayList<>();

    public List<RequestStatus> getRequestStatuses() {
        return requestStatuses;
    }

    public void setRequestStatuses(List<RequestStatus> requestStatuses) {
        this.requestStatuses = requestStatuses;
    }

    public Request() {}

    public Request(Long id, String firstName, String lastName, String cin, LocalDate birthDate, LocalDate startEmployementDate, Double monthlyIncome, Boolean hasActivateCredits, String email, String phoneNumber, String civility, String type, String position, String amount, int durationsInMonths, BigDecimal monthlyPayment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.birthDate = birthDate;
        this.startEmployementDate = startEmployementDate;
        this.monthlyIncome = monthlyIncome;
        this.hasActivateCredits = hasActivateCredits;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.civility = civility;
        this.type = type;
        this.position = position;
        this.amount = amount;
        this.durationsInMonths = durationsInMonths;
        this.monthlyPayment = monthlyPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getStartEmployementDate() {
        return startEmployementDate;
    }

    public void setStartEmployementDate(LocalDate startEmployementDate) {
        this.startEmployementDate = startEmployementDate;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public boolean isHasActivateCredits() {
        return hasActivateCredits;
    }

    public void setHasActivateCredits(boolean hasActivateCredits) {
        this.hasActivateCredits = hasActivateCredits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getDurationsInMonths() {
        return durationsInMonths;
    }

    public void setDurationsInMonths(int durationsInMonths) {
        this.durationsInMonths = durationsInMonths;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}