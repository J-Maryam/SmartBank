package com.smartbank.services.ServiceImpl;

import com.smartbank.models.Request;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestScoped
public class RequestServiceImpl implements RequestService {
    @Inject
    private RequestRepository requestRepository;
    private Validator validator;

    public RequestServiceImpl() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public void save(Request request) {
        // Validation des données de la demande
        Set<ConstraintViolation<Request>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Les données de la demande sont invalides : " + violations);
        }

        // Calcul de la mensualité
        BigDecimal mensualiteBackend = calculerMensualite(request.getAmount(), request.getDurationsInMonths());
        BigDecimal mensualiteFrontend = BigDecimal.valueOf(request.getMonthlyIncome());

        // Logs pour débogage
        System.out.println("Mensualité calculée (backend) : " + mensualiteBackend);
        System.out.println("Mensualité fournie (frontend) : " + mensualiteFrontend);

        // Comparaison des mensualités
        if (mensualiteBackend.setScale(2, RoundingMode.HALF_UP).compareTo(mensualiteFrontend) != 0) {
            throw new IllegalArgumentException("Le calcul des mensualités est incorrect. Veuillez vérifier vos données.");
        }

        // Sauvegarde de la demande
        requestRepository.save(request);
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request findById(Long id) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        return optionalRequest.orElse(null);
    }

    @Override
    public List<Request> filterRequests(LocalDate date, Long statusId) {
        return requestRepository.findByDateAndStatus(date, statusId);
    }

    public BigDecimal calculerMensualite(Long capital, int dureeEnMois) {
        // Vérification que le capital et la durée sont valides
        if (capital <= 0 || dureeEnMois <= 0) {
            throw new IllegalArgumentException("Le capital et la durée doivent être supérieurs à 0.");
        }

        double tauxAnnuel = 0.12; // 12%
        double tauxMensuel = tauxAnnuel / 12;

        // Calcul de la mensualité
        double mensualite = (capital * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeEnMois));

        return BigDecimal.valueOf(mensualite).setScale(2, RoundingMode.HALF_UP);
    }
}
