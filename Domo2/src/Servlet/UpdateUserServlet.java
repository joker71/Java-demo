package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import domo.beans.*;
import Utils.MyUtils;
/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet({"Updateinfor"})
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views//userUpdateInfor.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		String userName= (String) request.getParameter("userName");
		String fullName= (String) request.getParameter("fullName");
		String phone= (String) request.getParameter("phone");
		String email = (String) request.getParameter("email");
		String address= (String) request.getParameter("address");

		Customer customer= new Customer();
		customer.setUserName(userName);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setFullName(fullName);
		

		String regex= "\\w+";
		String errorString = null;

		if(errorString== null)
		{
			try{
				customer.updateInfor(conn);
			}
			catch(SQLException e){
				e.printStackTrace();
				errorString= e.getMessage();
			}
		}
		request.setAttribute("user", customer);
		if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/userUpdateInfor.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "userInforView.jsp");
        }
	}

}
