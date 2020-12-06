package Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import domo.beans.Product;
import domo.beans.UserAccount;
 
public class DBUtils {
 
    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
 // dùng cho đăng nhập
        String sql = "Select a.USER_NAME, a.GENDER, a.USER_ACTIVE, a.USER_ROLE from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("Gender");
            String role= rs.getString("USER_ROLE");
            String active= rs.getString("USER_ACTIVE");
            UserAccount user = new UserAccount(userName, password);
            user.setGener(gender);
            user.setRole(role);
            user.setActive(active);
            return user;
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.USER_NAME, a.GENDER, a.PASSWORD, a.USER_ACTIVE, a.USER_ROLE from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("PASSWORD");
            String gender = rs.getString("GENDER");
            String role= rs.getString("USER_ROLE");
            String active= rs.getString("USER_ACTIVE");
            UserAccount user = new UserAccount(userName, password);
            user.setGener(gender);
            user.setRole(role);
            user.setActive(active);
            return user;
        }
        return null;
    }
 
    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "Select a.CODE, a.NAME, a.SIZE, a.BRAND,A.COLOR, a.PRICEOUT, a.PRICEINT a.NUMBER from Product a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<domo.beans.Product> list = new ArrayList<domo.beans.Product>();
        while (rs.next()) {
            String code = rs.getString("CODE");
            String brand= rs.getString("BRAND");
            String name = rs.getString("NAME");
            String color = rs.getString("COLOR");
            int size= rs.getInt("SIZE");
            int number= rs.getInt("NUMBER");
            float priceint = rs.getFloat("PRICEINT");
            float priceout= rs.getFloat("PRICEOUT");
            Product product = new domo.beans.Product(code,name, size, brand, color, priceint, priceout);
            product.setNumber(number);
            list.add(product);
        }
        return list;
    }
 
    public static domo.beans.Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select a.CODE, a.NAME, a.SIZE, a.BRAND,A.COLOR, a.PRICEOUT, a.PRICEINT a.NUMBER from Product a where a.CODE=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String brand= rs.getString("BRAND");
            String name = rs.getString("NAME");
            String color = rs.getString("COLOR");
            int size= rs.getInt("SIZE");
            int number= rs.getInt("NUMBER");
            float priceint = rs.getFloat("PRICEINT");
            float priceout= rs.getFloat("PRICEOUT");
            Product product = new domo.beans.Product(code,name, size, brand, color, priceint, priceout);
            product.setNumber(number);
            return product;
        }
        return null;
    }
 
    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "Update Product set NAME =?, PRICEINT=? PRICEOUT= ? DES=? NUMBER= ? where CODE=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPriceint());
        pstm.setFloat(3, product.getPriceout());
        pstm.setString(4, product.getDescription());
        pstm.setString(6, product.getCode());
        pstm.setInt(5, product.getNumber());
        pstm.executeUpdate();
    }
 
    public static void insertProduct(Connection conn,  Product product) throws SQLException {
        String sql = "Insert into Product(code, name, size, brand, color, priceint, priceout, number) values (?,?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setInt(3, product.getSize());
        pstm.setString(4, product.getBrand());
        pstm.setString(5, product.getColor());
        pstm.setFloat(6, product.getPriceint());
        pstm.setFloat(7, product.getPriceout());
        pstm.setInt(8,product.getNumber());
        pstm.executeUpdate();
    }
 
    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "Delete From Product where Code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
 
}
