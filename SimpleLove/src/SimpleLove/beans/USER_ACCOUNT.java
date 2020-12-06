package SimpleLove.beans;

import java.sql.*;

public class USER_ACCOUNT {
	private String user_name;
	private String password;
	private String phone;
	private String email;
	private String role;
	private String active;
	private String address;
	private String gener;

	public static final String GENER_MALE = "M";
	public static final String GENER_FEMALE = "F";

	public static final String TRUE_ACTIVE = "1";
	public static final String FALSE_ACTIVE = "0";

	public USER_ACCOUNT() {

	}
	
	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String s) {
		this.password = s;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getGener() {
		return this.gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int ktrauser() {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "QLBH";
        String userName = "sa";
        String dbpassword = "1234";
        Statement statement = null;
        ResultSet rs=null;
        int kq=0;

        try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBH;",  userName, dbpassword);
	        //System.out.println("Connect DB: success!");
	        
	        String sql = "SELECT USER_NAME, PASSWORD FROM dbo.USER_ACCOUNT WHERE USER_NAME='"+this.user_name+"' AND PASSWORD='"+password+"'";
	        //String sql = "SELECT * FROM dbo.tbluser WHERE username='"+user_name+"' AND pass='"+password+"'";
	        //System.out.println("sql="+sql);
	        
	        //statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        statement=conn.createStatement();
	        rs=statement.executeQuery(sql);
	        if(rs.next())  kq=1;
	        
	        rs.close();
	        statement.close();
	        conn.close();
	        
        }catch(Exception e) {
	        System.out.println("Connect DB: Failed!" + e.toString());
        }
        
		return kq;
	}
	
}
