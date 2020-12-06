package SQL_demo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String dbURL= "jdbc: sqlserver://localhost;databaseName=QLSV;user=sa;password=123456";
		Connection conn= DriverManager.getConnection(dbURL);
		if(conn!=null)
		{
			System.out.println("Connectioned");
		}
		conn.close();
	}

}
