<%--
  Created by IntelliJ IDEA.
  User: TRQ1
  Date: 28/11/2018
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.HttpClientUtils" %>
<html>
<head>
    <title>HttpClient Get Test</title>
</head>
<body>
<%
    HttpClientUtils httpClient = new HttpClientUtils();
    httpClient.getContentUrl(request, "http://localhost:8080/test1.jsp");
%>
call test1.jsp
</body>
</html>
