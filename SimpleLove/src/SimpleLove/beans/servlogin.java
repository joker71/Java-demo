package SimpleLove.beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlogin
 */
@WebServlet("/servlogin")
public class servlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//Lay du lieu
		String username = (String)request.getParameter("parusername");
		String pass = (String)request.getParameter("parpass");
		System.out.println("servlet: username = "+ username + " pass="+pass);
		
		//Kiem tra du lieu
		USER_ACCOUNT uaobj = new USER_ACCOUNT();
		uaobj.setUserName(username);
		uaobj.setPassWord(pass);
		int kq=uaobj.ktrauser();
		if(kq==1) System.out.println("Co user roi - lam gi tiep thi lam nhe!");
		else System.out.println("Khong co usser");
		
		//System.out.println("Duoc goi tu login.jsp");
	}

}
