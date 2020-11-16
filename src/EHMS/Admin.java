package EHMS;
import java.sql.*;
import java.util.*;
public class Admin extends Person
{

	Scanner sc =new Scanner(System.in);
	private int AutoDoctorID()
	{
		int docid=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(UserID) as NextUserID from Users where userType='Doctor'");
			rs.next();
			docid = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return docid+1;
	}
	public int addDoctor()
	{
		int DoctorID=AutoDoctorID();
		String password;
		String cpd;
		System.out.println("Doctor ID:"+DoctorID);
		System.out.println("Enter Password:");
		password=sc.next();
		while(true)
		{
			System.out.println("Confirm Password Below");
			cpd=sc.next();
			if(password.compareTo(cpd)==0)
			{
				
				System.out.println("***Successfully Added DOCTOR***");
				System.out.println("DOCTOR-ID : "+DoctorID);
				System.out.println("PASSWORD : "+password);
				break;
			}
			else
			{
				System.out.println("**\tRE-ENTER The Password**");
			}
		}
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("insert into Users values('"+DoctorID+"','"+"Doctor"+"','"+password+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return DoctorID;
	}
	public void viewDoctors()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Doctors");
			con.close();
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  


	}
	public void viewPatients()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Patients");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
	}
	
	public void RemoveDoctor(int id)
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("delete  from Doctors where DoctorID = "+id);
			System.out.println("Removed Succesfully");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
	}
	
	
	public void Appointment() //case 5: in main.java file ---  Appointmnet Table ka content Show ho jayega.
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Appointments");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
		
	}  
	
	
	public void ViewFeedback() //admin can view all the feedback
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "feedback");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}	
	}
}
