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
//			String query = "select ContactNumber from Patients where PatientID = 1";
			Connection con=DriverManager.getConnection(url,uname,pass);
//			System.out.println("CONNECTION");
//			Statement st = con.createStatement();
//			ResultSet rs =  st.executeQuery(query);
//			rs.next();
			
//			String name = rs.getString("ContactNumber");
//			System.out.println(name);
			
//			System.out.println("Successful");
			return con;
		}
		catch(Exception e) {
			return null;
		}
	}
}
