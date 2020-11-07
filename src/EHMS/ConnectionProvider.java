package EHMS;
import java.sql.*;
public class ConnectionProvider {
	public static Connection getCon()
	{
		try {
			String url="jdbc:mysql://localhost:3306/HealthcareMangaementSystem";
			String uname="root";
			String pass="jain@123";
			String query = "select ContactNumber from Patients where PatientID = 1";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(query);
			rs.next();
			
			String name = rs.getString("ContactNumber");
			System.out.print(name);
			return con;
		}catch(Exception e) {
			return null;
		}
	}

}
