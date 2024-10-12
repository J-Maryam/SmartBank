<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Demandes</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7f9;
            color: #333;
        }

        h1, h2 {
            text-align: center;
            color: #30435C;
            margin: 20px 0;
        }

        .container {
            width: 90%;
            margin: auto;
            overflow: hidden;
        }

        .filter {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #02AFBC;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .topnav {
            display: flex;
            align-items: center;
            flex-grow: 1;
        }

        .topnav input[type=text] {
            padding: 10px;
            margin-left: 10px;
            border: 1px solid #9B9B9B;
            border-radius: 5px;
            width: 250px;
        }

        .topnav button {
            padding: 10px;
            margin-left: 10px;
            background-color: #FDDF35;
            color: black;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .topnav button:hover {
            background-color: #02AFBC;
        }

        .table-container {
            width: 100%;
            overflow-x: auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            table-layout: auto; /* S'assure que le tableau s'adapte à la largeur */
        }

        th, td {
            white-space: nowrap;
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #02AFBC;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .btn-group {
            display: flex;
            justify-content: space-between;
        }

        .button {
            background-color: #FDDF35;
            color: black;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none; /* Pour retirer le soulignement des liens */
            text-align: center; /* Centrer le texte dans les boutons */
        }

        .button:hover {
            background-color: #02AFBC;
        }

        /* Styles pour la popup */
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.7);
            transition: opacity 500ms;
            visibility: hidden;
            opacity: 0;
        }

        .overlay:target {
            visibility: visible;
            opacity: 1;
        }

        .popup {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: white;
            padding: 20px;
            border-radius: 10px;
            width: 300px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
        }

        .popup h2 {
            margin-top: 0;
            color: #30435C;
        }

        .popup .close {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            cursor: pointer;
            color: #30435C;
        }

        .popup .close:hover {
            color: #02AFBC;
        }

        .updateForm {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .updateForm input[type="text"],
        .updateForm select {
            padding: 10px;
            border: 1px solid #9B9B9B;
            border-radius: 5px;
            width: 100%;
        }

        .updateForm input[type="submit"] {
            background-color: #02AFBC;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .updateForm input[type="submit"]:hover {
            background-color: #FDDF35;
        }

        @media (max-width: 768px) {
            .container {
                width: 95%;
            }

            .topnav input[type=text] {
                width: 100%; /* Adaptation de la largeur sur mobile */
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h3>Liste des demandes</h3>
    <div class="filter">
        <div class="topnav">
            <label for="search">Filtrer par date: </label>
            <input type="text" id="search" placeholder="Rechercher...">
            <button type="submit">Rechercher</button>
        </div>
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
            <c:if test="${not empty requestList}">
                <c:forEach var="request" items="${requestList}">
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
                                <a class="button update-status" href="#popup2">Modifier le statut</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty requestList}">
                <tr>
                    <td colspan="15" style="text-align: center;">Aucune demande trouvée.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>

    <div id="popup2" class="overlay">
        <div class="popup">
            <h2>Modifier la statut de la demande</h2>
            <span class="close" onclick="document.getElementById('popup2').style.display='none'">&times;</span>
            <div class="content">
                <form class="updateForm">
                    <label for="status">Statut</label>
                    <select id="status" name="status">
                        <option value="pending">En attente</option>
                        <option value="accepted">Accepté</option>
                        <option value="refused">Refusé</option>
                    </select>

                    <label for="justification">Justification</label>
                    <input type="text" id="justification" name="justification" required>

                    <input type="submit" value="Mettre à jour">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script>
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    function filterFunction() {
        const input = document.getElementById("myInput");
        const filter = input.value.toUpperCase();
        const div = document.getElementById("myDropdown");
        const a = div.getElementsByTagName("a");
        for (let i = 0; i < a.length; i++) {
            txtValue = a[i].textContent || a[i].innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                a[i].style.display = "";
            } else {
                a[i].style.display = "none";
            }
        }
    }
</script>

