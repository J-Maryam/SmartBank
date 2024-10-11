<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>details</title>
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
