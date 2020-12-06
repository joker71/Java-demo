package SimpleLove.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SQLServerConnUtils_JTDS {
 
    // TAO CHUOI DUNG DE CONNECT
    public static Connection getSQLServerConnection_JTDS() //
            throws SQLException, ClassNotFoundException {
 
        
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "QLBH";
        String userName = "sa";
        String password = "1234";
 
        return getSQLServerConnection_JTDS(hostName, sqlInstanceName, database, userName, password);
    }
 
   
    private static Connection getSQLServerConnection_JTDS(String hostName, //
            String sqlInstanceName, String database, String userName, String password)
            throws ClassNotFoundException, SQLException {
 
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" //
                + database + ";instance=" + sqlInstanceName;
 
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
 
}