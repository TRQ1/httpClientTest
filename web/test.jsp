<%--
  Created by IntelliJ IDEA.
  User: TRQ1
  Date: 27/11/2018
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.UrlConnection" %>
<%
    UrlConnection urlConnection = new UrlConnection();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String result3 = urlConnection.postUrl(request, response, "http://localhost:8080/login.jsp?userId=q1&userPassword=qwer0987");
%>
<%=result3%>
</body>
</html>
