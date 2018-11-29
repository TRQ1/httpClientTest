<%--
  Created by IntelliJ IDEA.
  User: TRQ1
  Date: 28/11/2018
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.HttpClientUtils" %>
<html>
<head>
    <title>HttpClient Post Test</title>
</head>
<body>
<%
    HttpClientUtils httpClient = new HttpClientUtils();
    String result = httpClient.postContentUrl("http://localhost:8080");
%>
<%=result%>
</body>
</html>
