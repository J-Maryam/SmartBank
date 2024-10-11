<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Détails des Demandes de Crédit</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h3 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        .content {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:nth-child(odd) {
            background-color: #fff;
        }

        @media (max-width: 600px) {
            th, td {
                padding: 8px;
                font-size: 14px;
            }

            h3 {
                font-size: 18px;
            }
        }
    </style>
</head>
<body>
<h3>Historiques de demande de crédit</h3>
<div class="content">
    <table>
        <tr>
            <th>Demande</th>
            <th>Status</th>
            <th>Date</th>
            <th>Justification</th>
        </tr>
        <c:forEach var="status" items="${requestStatusList}">
            <tr>
                <td>${status.request.type}</td>
                <td>${status.status.status}</td>
                <td>${status.statusDate}</td>
                <td>${status.justification}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
