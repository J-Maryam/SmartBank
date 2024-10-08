<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            padding: 2%;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
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

        .show {
            display: block;
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
    </style>
</head>
<body>

<div class="filter">
    <div class="topnav">
        <a class="active" href="#home">Filter by Date: </a>
        <div class="search-container">
            <form action="/action_page.php">
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

<table>
    <tr>
        <th>Client</th>
        <th>Request</th>
        <th>Mensualités (en DH)</th>
        <th></th>
    </tr>
    <c:forEach var="request" items="${requestList}">
        <tr>
            <td>${request.firstName} ${request.lastName}</td>
            <td>${request.type}</td>
            <td>${request.monthlyPayment}</td>
            <td>
                <div class="btn-group">
                    <button class="button">Details</button>
                    <button class="button">Update</button>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
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
</html>