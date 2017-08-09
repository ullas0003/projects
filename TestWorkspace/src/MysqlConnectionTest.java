//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
public class MysqlConnectionTest {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/test";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root123";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
		public static void main(String[] args) {
		int n = 0xa;
		ArrayList ad = new ArrayList();
		//Class.forName(JDBC_DRIVER);
		String query = "select * from employees";
		try{
			Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				//System.out.println(rs.getInt("emp_id"));
				//System.out.println(rs.getString("emp_name"));
				ad.add(rs.getString("emp_name"));
				System.out.printf("the value is %s\n", rs.getString("emp_name"));
			}
			System.err.println(ad);
			
			System.out.println(n);

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}