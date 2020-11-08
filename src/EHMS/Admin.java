package EHMS;
import EHMS.ConnectionProvider;
import java.sql.*;
import java.util.*;
public class Admin extends Person
{
	
	Scanner sc =new Scanner(System.in);
	private  int pid;
	private  int docid;
	private static int temp1;
	private static int temp2;
	static
	{
		temp1=1;
		temp2=1;
	}
	// static int generatePatientID()
	// {
		
	// 	try
	// 	{
	// 		Connection con=ConnectionProvider.getCon();
	// 		Statement st=con.createStatement();
		
	// 		ResultSet rs=st.executeQuery("Select MAX(UserID) from Users where userType is Patient");
	// 		rs.next();
	// 		rs.getInt("MAX(UserID)");
	// 		// if(rs.getInt("MAX(UserID)"))
	// 		// 	return 1;
	// 		// else
	// 		// 	return id+1;
				
			
	// 	}catch(Exception e)
	// 	{
			
	// 	}
	// }
	static int generateDoctorID()
	{
		return temp2++;
	}
//	public int addPatient() 
//	{
//		int PatientID=generatePatientID();
//		String password;
//		String cpd;
//		System.out.println("Patient ID:"+PatientID);
//		System.out.println("Enter Password:");
//		password=sc.next();
//		while(true)
//		{
//			System.out.println("Confirm Password");
//			cpd=sc.next();
//			if(password.compareTo(cpd)==0)
//					break;
//		}
//		try {
//			Connection con=ConnectionProvider.getCon();
//			Statement st=con.createStatement();
//			st.executeUpdate("insert into Users values('"+PatientID+"','"+password+"','"+"Patient"+"')");
//			System.out.println("Registered Succesfully!!");
//		}catch(Exception e){
//			System.out.println("Please enter data in correct format!!");
//		}
//		return PatientID;
//		
//		
//		
//	}
	
	
	/*
	 * Admin had to Set Fees of  a Particular Doctor jb bhi vo add krega a New Doctor and vo fees doctor database table me bhi ajayegi..
	 * It would make payment details easier. */
	
	
	public int addDoctor()
	{
		int DoctorID=generateDoctorID();
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
			st.executeUpdate("insert into Users values('"+DoctorID+"','"+password+"','"+"Doctor"+"')");
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
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{				
				System.out.print("\t********************************************************************************************************************\n");
				System.out.print("\t| DoctorID | First_Name | Last_Name | Gender | ContactNumber | Age  | Entry_Charge | Degree | Department | address |\n");
				System.out.print("\t| "+rs.getInt(1)+"        | "+rs.getString(2)+" - "+rs.getString(3)+"          | "+rs.getString(4)+"      | "+rs.getString(5)+"       | "+rs.getInt(6)+"   | "+rs.getString(7)+"          | "+rs.getString(8)+"    | "+rs.getString(9)+"    | "+rs.getString(10));
				System.out.println("\n");
			}
			st.close();
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
			Statement st=con.createStatement();
			String query="select * from Patients";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.println("PatientID - "+rs.getInt(1));
				System.out.println("NAME  -     "+rs.getString(2)+rs.getString(3));
				System.out.println("Gender -    "+rs.getString(4));
				System.out.println("Contact Number  - "+rs.getString(5));
				System.out.println("Age-        "+rs.getInt(6));
				System.out.println("Email-ID -  "+rs.getString(7));
				System.out.println("BloodGroup - "+rs.getString(8));
				System.out.println("Adress  -   "+rs.getString(9));
				System.out.println("---------------------------------------");
				System.out.println("---------------------------------------");
				
			}
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
			st.executeUpdate("");
			System.out.println("Removed Succesfully");
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
	public void RemovePatient(int id) 
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("");
			System.out.println("Removed Succesfullu");
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
	public void viewPatientReport() {}//admin can view all the patient reports
	//public void GenerateDoctorSalary() {}
	public void ViewDoctorShedule() {}
	public void ViewFeedback() //admin can view all the feedback
	{
		
	}
	public void viewAppointment() 
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
		}catch(Exception e)
		{
			
		}
	}//admin can view all the appointment
	public void GenerateBill() {}
	public void ViewPaymentDetails() {}//admin can view all the paid bills list

}
