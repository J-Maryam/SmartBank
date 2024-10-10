<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="${pageContext.request.contextPath}/requests">
  <button type="submit">Toutes les Demandes</button>
</form>

<form action="${pageContext.request.contextPath}/step1.jsp">
  <button type="submit">demander un credit</button>
</form>
</body>
</html>