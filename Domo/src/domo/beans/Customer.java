package domo.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sun.net.smtp.SmtpClient;

public class Customer extends UserAccount {
    private String fullName;

    public void setFullName(String s) {
        this.fullName = s;
    }

    public String getFullName() {
        return fullName;
    }

    public void updateInfor(Connection conn) throws SQLException {
        String sql = "Update USER_ACCOUNT SET  USER_FULLNAME= ? GENDER= ? ADDRESS= ? PHONE= ? EMAIL=? WHERE USER_NAME= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, this.fullName);
        pstm.setString(2, this.getGener());
        pstm.setString(3, this.getAddress());
        pstm.setString(4, this.getPhone());
        pstm.setString(5, this.getEmail());
        pstm.setString(6, this.getUserName());
        pstm.executeUpdate();
    }
    public void changeState(Connection conn) throws SQLException {
        String sql = "Update USER_ACCOUNT SET  ACTIVE= ? WHERE USER_NAME= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, "0");
        pstm.setString(2, this.getUserName());
     
        pstm.executeUpdate();
    }
    public UserAccount inforPrivate(Connection conn) throws SQLException
	{
		
        String sql = "Select a.USER_NAME, a.USER_FULLNAME, a.GENDER, a.PASSWORD, a.PHONE, a.EMAIL, a.ADDRESS from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, this.getUserName());
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("PASSWORD");
            String gender = rs.getString("GENDER");
            String phone= rs.getString("PHONE");
            String email= rs.getString("EMAIL");
            String address= rs.getString("ADDRESS");
            String fullName= rs.getString("USER_FULLNAME");
            this.setGener(gender);
            this.setPhone(phone);
            this.setEmail(email);
            this.setFullName(fullName);
			this.setAddress(address);
			this.setPassWord(password);
            return this;
        }
        return null;
		
	}
}
