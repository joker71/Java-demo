<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <!DOCTYPE html>
   <html>

   <head>
      <meta charset="UTF-8">
      <title>Update Infor</title>
   </head>

   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>

      <h3>Update infor</h3>
      <p style="color: red;">${errorString}</p>


      <form method="POST" action="${pageContext.request.contextPath}/Updateinfor">
         <table border="0">
            <tr>
               <td>User Name</td>
               <td><input type="text" name="userName" value="${user.userName}" /> </td>
            </tr>
            <tr>
               <td>Full Name</td>
               <td><input type="text" name="fullName" value="${user.fullName}"></td>
            </tr>
            <tr>
               <td>Phone</td>
               <td><input type="password" name="phone" value="${user.phone}" /> </td>
            </tr>
            <tr>
               <td>Address</td>
               <td><input type="text" name="address" value="${user.address}"></td>
            </tr>
            <tr>
               <td>Email</td>
               <td><input type="text" name="email" value="${user.email}"></td>
            </tr>

            <tr>
               <td colspan="2">
                  <input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form>

    

      <jsp:include page="_footer.jsp"></jsp:include>
   </body>

   </html>