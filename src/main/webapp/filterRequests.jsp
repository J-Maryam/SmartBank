<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/requests.css">
    <title>Liste des Demandes</title>
</head>
<body>
<div class="container">
    <h3>Liste des demandes</h3>

    <div class="filter">
        <form action="${pageContext.request.contextPath}/filterRequests">
            <div class="topnav">
                <div>
                    <label >Filtrer par date: </label>
                    <input type="date" name="date" class="date-input">
                </div>
                <div>
                    <label for="status-filter">Filtrer par statut: </label>
                    <select id="status-filter" class="status-select" name="statusId">
                        <option value="">Tous</option>
                        <c:forEach var="status" items="${statusList}">
                            <option value="${status.id}">${status.status}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="search-button">Rechercher</button>
            </div>
        </form>
    </div>

    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Client</th>
                <th>CIN</th>
                <th>Date de naissance</th>
                <th>Email</th>
                <th>Téléphone</th>
                <th>Civilité</th>
                <th>Type de demande</th>
                <th>Position</th>
                <th>Date d'embauche/Début de l'activité</th>
                <th>Montant</th>
                <th>Durée</th>
                <th>Mensualités (en DH)</th>
                <th>Total revenus mensuels (en DH)</th>
                <th>Crédit (hasActivateCredits)</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty filterRequests}">
                <c:forEach var="request" items="${filterRequests}">
                    <tr>
                        <td>${request.firstName} ${request.lastName}</td>
                        <td>${request.cin}</td>
                        <td>${request.birthDate}</td>
                        <td>${request.email}</td>
                        <td>${request.phoneNumber}</td>
                        <td>${request.civility}</td>
                        <td>${request.type}</td>
                        <td>${request.position}</td>
                        <td>${request.startEmployementDate}</td>
                        <td>${request.amount}</td>
                        <td>${request.durationsInMonths}</td>
                        <td>${request.monthlyIncome}</td>
                        <td>${request.monthlyPayment}</td>
                        <td>${request.hasActivateCredits}</td>
                        <td>
                            <div class="btn-group">
                                <a class="button" href="${pageContext.request.contextPath}/details?id=${request.id}">Détails</a>
                                <button class="button update-status" onclick="openPopup(${request.id}, '${pageContext.request.contextPath}/updateStatus?id=${request.id}')">
                                    Modifier le statut
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty filterRequests}">
                <tr>
                    <td colspan="15" style="text-align: center;">Aucune demande trouvée.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>

    <c:forEach var="request" items="${filterRequests}">
        <div id="popup-${request.id}" class="popup" style="display: none;">
            <div class="popup-content">
                <h2>Modifier le statut de la demande <span id="requestId-${request.id}"></span></h2>
                <span class="close" onclick="closePopup(${request.id})">&times;</span>
                <div class="content">
                    <form class="updateForm" id="updateForm-${request.id}" method="post">
                        <input type="hidden" name="request_id" value="${request.id}">
                        <label for="status">Statut</label>
                        <select id="status" name="status">
                            <c:forEach var="status" items="${statusList}">
                                <option value="${status.id}">${status.status}</option>
                            </c:forEach>
                        </select>

                        <label for="justification">Justification</label>
                        <input type="text" id="justification" name="justification" required>

                        <input type="submit" value="Mettre à jour">
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>

</div>
<script src="assets/js/details.js"></script>

</body>
</html>

