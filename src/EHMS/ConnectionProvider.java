package EHMS;
import java.sql.*;
public class ConnectionProvider {
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/HealthcareMangaementSystem";
			String uname="root";
			String pass="root123@";
			Connection con=DriverManager.getConnection(url,uname,pass);
			return con;
		}
		catch(Exception e) {
			return null;
		}
	}
}
