<%--
  Created by IntelliJ IDEA.
  User: TRQ1
  Date: 27/11/2018
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    throw new Exception("Exception");
    if(response.getStatus() == 500) {
%>
<h color="red">Error: <%=exception.getMessage(); %></h><br>
<h color="red">Code: <%=response.getStatus()%></h>
<%
    } else {
%>
Error: <%=exception.getMessage() %>
code: <%=response.getStatus() %>
<%
    }
%>
</body>
</html>
