<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="domo.beans.Product"%>
<%@page import="domo.beans.UserAccount"%>
<%@page import="domo.beans.Customer"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <% UserAccount cus = (UserAccount) request.getAttribute("user"); %>
   
    
    <br />
    User Phone: <b><%=cus.getPhone()%></b>
    <br />
    User Email: <b><%=cus.getEmail()%></b>
    <br />
    User Address: <b><%=cus.getAddress()%></b>
    <br />
    Gender: ${cus.getGener(); } <br />
    
    <hr  width="30%" size="10px" align="center" />
  

    
 
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
