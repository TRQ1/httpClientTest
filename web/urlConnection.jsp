<%--
  Created by IntelliJ IDEA.
  User: TRQ1
  Date: 26/11/2018
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.UrlConnection" %>
<%
    UrlConnection urlConnection = new UrlConnection();
%>
<html>
<head>
    <title>Test Get urlConnection</title>
</head>
<body>
<%
    urlConnection.getUrl("http://localhost:8080/test.jsp");
%>
call test.jsp
</body>
</html>
