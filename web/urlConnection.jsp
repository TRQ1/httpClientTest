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

    int code;
    code = Integer.parseInt(request.getParameter("idx"));
    System.out.println(code);
    String result1 = urlConnection.getUrl(request, response, "http://localhost:8080");
    String result2 = urlConnection.getUrl(request, response, "http://localhost:8080?id=1&pg=30");
    String result3 = urlConnection.postUrl(request, response, "http://localhost:8080/login.jsp?userId=q1&userPassword=qwer0987");
%>
<%
   if (code == 1) {
%>
<%=result1%>
<%
    } else if (code == 2) {
%>
<%=result3%>
<%
    } else {
%>
<%=result2%>
<%
    }
%>
</body>
</html>
