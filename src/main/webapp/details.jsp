<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/details.css">
    <title>Détails des Demandes de Crédit</title>
</head>
<body>
<header>Détails des Demandes de Crédit</header>
<div class="content">
    <h3>Historiques de demande de crédit</h3>
    <table>
        <tr>
            <th>Demande</th>
            <th>Status</th>
            <th>Date</th>
            <th>Justification</th>
        </tr>
        <c:forEach var="status" items="${requestStatusList}">
            <tr>
                <td style="white-space: nowrap;">
                    <i class="icon">&#128221;</i> <!-- Icône pour la demande -->
                        ${status.request.type}
                </td>
                <td style="white-space: nowrap;">
                    <i class="icon">&#128276;</i> <!-- Icône pour le statut -->
                        ${status.status.status}
                </td>
                <td style="white-space: nowrap;">${status.statusDate}</td>
                <td>${status.justification}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
