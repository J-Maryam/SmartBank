<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Requests</title>
    <style>
        body {
            padding: 2%;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            margin: auto;
        }

        th {
            /*border: 1px solid #dddddd;*/
            background-color: #dddddd;
            text-align: left;
            padding: 12px;
        }

        td {
            border-bottom: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
        }

        .filter {
            display: grid;
            gap: 3%;
            align-items: center;
            margin: auto;
            padding: 5%;
        }

        .dropbtn {
            background-color: darkgray;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
        }

        .dropbtn:hover, .dropbtn:focus {
            /*background-color: #3e8e41;*/
        }

        #myInput {
            box-sizing: border-box;
            /*background-image: url('searchicon.png');*/
            background-position: 14px 12px;
            background-repeat: no-repeat;
            font-size: 16px;
            padding: 14px 20px 12px 45px;
            border: none;
            border-bottom: 1px solid #ddd;
        }

        #myInput:focus {
            outline: 3px solid #ddd;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f6f6f6;
            min-width: 230px;
            overflow: auto;
            border: 1px solid #ddd;
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown a:hover {
            background-color: #ddd;
        }

        .topnav {
            overflow: hidden;
            background-color: darkgray;
            width: 40%;
            border-radius: 10px;
        }

        .topnav a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            /*background-color: #ddd;*/
            color: black;
        }

        .topnav a.active {
            /*background-color: #2196F3;*/
            color: white;
        }

        .topnav .search-container {
            float: right;
        }

        .topnav input[type=text] {
            padding: 6px;
            margin-top: 8px;
            font-size: 17px;
            border: none;
        }

        .topnav .search-container button {
            float: right;
            padding: 6px 10px;
            margin-top: 8px;
            margin-right: 16px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }

        .topnav .search-container button:hover {
            background: #ccc;
        }

        .btn-group .button {
            background-color: darkgray;
            border: none;
            border-radius: 10px;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            justify-content: space-between;
            align-items: center;
            font-size: 16px;
            cursor: pointer;
        }

        .btn-group .button:hover {
            background-color: gray;
        }

        .table-container {
            width: 100%;
            margin: auto;
            overflow-x: auto;
            border: 1px solid #ddd;
        }

        h1 {
            text-align: center;
            font-family: Tahoma, Arial, sans-serif;
            color: #06D85F;
            margin: 80px 0;
        }

        .box {
            width: 40%;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.2);
            padding: 35px;
            border: 2px solid #fff;
            border-radius: 20px/50px;
            background-clip: padding-box;
            text-align: center;
        }

        .button {
            font-size: 1em;
            padding: 10px;
            color: #fff;
            border: 2px solid #06D85F;
            border-radius: 20px/50px;
            text-decoration: none;
            cursor: pointer;
            transition: all 0.3s ease-out;
        }

        .button:hover {
            background: #06D85F;
        }

        .overlay {
            display: none;
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
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
            margin: 70px auto;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            width: 30%;
            position: relative;
            transition: all 0.3s ease-in-out;
        }

        .popup h2 {
            margin-top: 0;
            color: #333;
            font-family: Tahoma, Arial, sans-serif;
        }

        .popup .close {
            position: absolute;
            top: 20px;
            right: 30px;
            transition: all 200ms;
            font-size: 30px;
            font-weight: bold;
            text-decoration: none;
            color: #333;
        }

        .popup .close:hover {
            color: #06D85F;
        }

        .popup .content {
            max-height: 30%;
            overflow: auto;
        }

        .updateForm {
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>

<div class="filter">
    <div class="topnav">
        <a class="active">Filter by Date: </a>
        <div class="search-container">
            <form>
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i>Search</button>
            </form>
        </div>
    </div>
    <div class="dropdown">
        <button onclick="myFunction()" class="dropbtn">Dropdown</button>
        <div id="myDropdown" class="dropdown-content">
            <input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">
            <a href="#about">About</a>
            <a href="#base">Base</a>
            <a href="#blog">Blog</a>
            <a href="#contact">Contact</a>
            <a href="#custom">Custom</a>
            <a href="#support">Support</a>
            <a href="#tools">Tools</a>
        </div>
    </div>
</div>

<h2>Request List</h2>

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
            <th></th>
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
                            <a class="button update-status" href="#">Update Status</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty requestList}">
            <tr>
                <td colspan="15">Aucun crédit trouvé.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<%--for to modify request status--%>
<div id="popup2" class="overlay">
    <div class="popup">
        <h3>Modifier la statut de la demande</h3>
        <a class="close" href="#">&times;</a>
        <div class="content">
            <div class="updateForm">
                <form>
                    <label for="status">Country</label>
                    <select id="status" name="status">
                        <option value="pending">En attente</option>
                        <option value="accepted">Accepté</option>
                        <option value="refused">Refusé</option>
                    </select>

                    <label for="justification">First Name</label>
                    <input type="text" id="justification" name="justification" placeholder="Your justification..">

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script src="assets/details.js"></script>

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

