package domo.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccount {
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

	public UserAccount(String user, String pass) {
		this.password= pass;
		this.user_name= user;
	}
	public UserAccount() {
		
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
	public boolean checkExist() {
		
		
		return true;
	}
	public UserAccount findUser(Connection conn) throws SQLException
	{
		String sql = "Select a.GENDER, a.USER_ACTIVE, a.USER_ROLE from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, this.user_name);
        pstm.setString(2, this.password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()){
			String gender = rs.getString("Gender");
            String role= rs.getString("USER_ROLE");
            String active= rs.getString("USER_ACTIVE");
            this.setGener(gender);
            this.setRole(role);
            this.setActive(active);
			return this;
		}
		else return null;
		
	}
	public UserAccount findUserbyName(Connection conn) throws SQLException
	{
		
        String sql = "Select a.USER_NAME, a.GENDER, a.PASSWORD, a.USER_ACTIVE, a.USER_ROLE from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, this.user_name);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("PASSWORD");
            String gender = rs.getString("GENDER");
            String role= rs.getString("USER_ROLE");
            String active= rs.getString("USER_ACTIVE");
            this.setGener(gender);
            this.setRole(role);
			this.setActive(active);
			this.setPassWord(password);
            return this;
        }
        return null;
		
	}
	
	
}
