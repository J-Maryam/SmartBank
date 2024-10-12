<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Hello World</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 40px;
      text-align: center;
    }

    h1 {
      color: #02AFBC; /* Couleur mise à jour du titre */
      margin-bottom: 30px;
    }

    form {
      margin: 20px 0;
    }

    button {
      background-color: #02AFBC; /* Couleur de fond mise à jour */
      color: white; /* Texte en blanc */
      padding: 10px 20px; /* Rembourrage */
      border: none; /* Pas de bordure */
      border-radius: 5px; /* Coins arrondis */
      cursor: pointer; /* Curseur pointer pour indiquer cliquable */
      font-size: 16px; /* Taille de la police */
      transition: background-color 0.3s; /* Effet de transition */
    }

    button:hover {
      background-color: #FDDF35; /* Couleur de fond au survol mise à jour */
    }

    button:focus {
      outline: none; /* Enlève le contour au focus */
    }
  </style>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>

<form action="${pageContext.request.contextPath}/requests">
  <button type="submit">Toutes les Demandes</button>
</form>

<form action="${pageContext.request.contextPath}/step1.jsp">
  <button type="submit">Demander un Crédit</button>
</form>
</body>
</html>
