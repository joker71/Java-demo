<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="domo.beans.Product"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 	<%
 		List <Product> listhung = (List) request.getAttribute("productList");
 	%>
    <table >
       <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <%
       		for(int i=0;i<listhung.size();i++){
       %>
       <tr>
       		<td><%=listhung.get(i).getCode()%></td>
       		<td><%=listhung.get(i).getName()%></td>
       		<td><%=listhung.get(i).getPriceout()%></td>
       		<td>
                <a href="editProduct?code=${product.code}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
             </td>
       </tr>
       <% } %>
    </table>
 
    <a href="createProduct" >Create Product</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>