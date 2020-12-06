package domo.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    /**
     *
     */
    
    private String code;
    private String brand;
    private String color;
    private String name;
    private int size;
    private int number;
    private float priceint;
    private float priceout;
    private String description;

    public Product(String code, String name, int size, String brand, String color, float priceint, float priceout) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.brand = brand;
        this.color = color;
        this.priceout = priceout;
        this.priceint = priceint;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String code) {
        this.color = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getPriceint() {
        return priceint;
    }

    public void setPriceint(float price) {
        this.priceint = price;
    }

    public float getPriceout() {
        return priceout;
    }

    public void setPrice(float price) {
        this.priceout = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        this.description = des;
    }

    public void setNumber(int n) {
        this.number = n;
    }

    public int getNumber() {
        return this.number;
    }

    public List<Product> queryProduct(Connection conn) throws SQLException { // xem list san pham
        String sql = "Select a.CODE, a.NAME, a.SIZE, a.BRAND,A.COLOR, a.PRICEOUT, a.PRICEINT a.NUMBER from Product a ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("CODE");
            String brand = rs.getString("BRAND");
            String name = rs.getString("NAME");
            String color = rs.getString("COLOR");
            int size = rs.getInt("SIZE");
            int number = rs.getInt("NUMBER");
            float priceint = rs.getFloat("PRICEINT");
            float priceout = rs.getFloat("PRICEOUT");
            this.setCode(code);
            this.setBrand(brand);
            this.setName(name);
            this.setColor(color);
            this.setSize(size);
            this.setNumber(number);
            this.setNumber(number);
            this.setPriceint(priceint);
            this.setPrice(priceout);
            list.add(this);
        }
        return list;
    }

    public Product getDetailProduct(Connection conn) throws SQLException {// xem 1 sp theo ma
        String sql = "Select a.CODE, a.NAME, a.SIZE, a.BRAND,A.COLOR, a.PRICEOUT, a.PRICEINT a.NUMBER from Product a where a.CODE=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, this.code);

        ResultSet rs = pstm.executeQuery();
       
        while (rs.next()) {
            String brand = rs.getString("BRAND");
            String name = rs.getString("NAME");
            String color = rs.getString("COLOR");
            int size = rs.getInt("SIZE");
            int number = rs.getInt("NUMBER");
            float priceint = rs.getFloat("PRICEINT");
            float priceout = rs.getFloat("PRICEOUT");
            this.setBrand(brand);
            this.setColor(color);
            this.setName(name);
            this.setSize(size);
            this.setNumber(number);
            this.setPrice(priceout);
            this.setPriceint(priceint);
            return this;
        }
        return null;
    }

    public void updateProduct(Connection conn) throws SQLException { // cap nhat sp
        String sql = "UPDATE_PRODUCT_SET_NAME_PRICEINT_PRICEOUT_DES_NUMBER_WHERE_CODE";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, this.getName());
        pstm.setFloat(2, this.getPriceint());
        pstm.setFloat(3, this.getPriceout());
        pstm.setString(4, this.getDescription());
        pstm.setString(6, this.getCode());
        pstm.setInt(5, this.getNumber());
        pstm.executeUpdate();
    }

    public void changeProduct(Connection conn, int addNumber) throws SQLException { //thay doi so luong sp 
        String sql = "Update Product set  NUMBER= ? where CODE=? ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, this.number + addNumber);
        pstm.setString(2, this.code);
    }

    public void insertProduct(Connection conn) throws SQLException { // them sp
        String sql = "Insert into Product(code, name, size, brand, color, priceint, priceout, number) values (?,?,?,?,?,?,?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, this.getCode());
        pstm.setString(2, this.getName());
        pstm.setInt(3, this.getSize());
        pstm.setString(4, this.getBrand());
        pstm.setString(5, this.getColor());
        pstm.setFloat(6, this.getPriceint());
        pstm.setFloat(7, this.getPriceout());
        pstm.setInt(8, this.getNumber());
        pstm.executeUpdate();
    }

    public void deleteProduct(Connection conn) throws SQLException { // xao sp
        String sql = "Delete From Product where Code= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, this.code);

        pstm.executeUpdate();
    }

}
