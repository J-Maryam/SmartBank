<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Détails des Demandes de Crédit</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #02AFBC;
            color: white;
            padding: 20px 0;
            text-align: center;
            font-size: 24px;
        }

        .content {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 900px;
            margin: 30px auto;
        }

        h3 {
            color: #333;
            text-align: center;
            margin-bottom: 25px;
            font-size: 22px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #02AFBC;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 14px;
        }

        td {
            color: #555;
        }

        tr:hover {
            background-color: #e0f7fa;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .icon {
            margin-right: 8px;
        }

        /* Mobile view */
        @media (max-width: 600px) {
            th, td {
                padding: 10px;
                font-size: 14px;
            }

            h3 {
                font-size: 18px;
            }

            header {
                font-size: 20px;
            }
        }
    </style>
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
