package EHMS;
import EHMS.ConnectionProvider;
import EHMS.Register;
import java.sql.*;

import java.util.Scanner;
public class Patients extends Person
{
	Scanner sc=new Scanner(System.in);
    String BloodGroup ;
    private int AutoPatientID()
	{
		int id_Patient=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(UserID) as NextUserID from Users where userType='Patient'");
			rs.next();
			id_Patient = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return id_Patient+1;
	}
    public int addPatient() 
	{
		int PatientID=AutoPatientID();
		String password;
		String cpd;
		System.out.println("Patient ID: "+PatientID);
		System.out.println("Enter Password: ");
		password=sc.next();
		while(true)
		{
			System.out.println("Confirm Password Below");
			cpd=sc.next();
			if(password.compareTo(cpd)==0)
			{
				
				System.out.println("*** Successfull Registration ***");
				System.out.println("PATIENT-ID : "+PatientID);
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
			st.executeUpdate("insert into Users values('"+PatientID+"','"+password+"','"+"Patient"+"')");
//			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return PatientID;
		
	}
    public void PatientRegistration(int pid) 
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup,Address);
 
    }
    public void ShowPatientDetails(int id)
    {
    	try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Patients");
			con.close();
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
	}
    public void viewDoctor()
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
    public void BookAppointment(int id) 
    {
    	Appointment ap=new Appointment();
    	ap.BookAppointment(id);
    	
    	
    	
    }
    public void viewAppointment() 
    {
    	
    }
    public void GetPatientStatus() 
    {
    	
    }
    public void ViewReport()
    {
    	
    }
    public void CancelAppointments() {
    	
    }
    public void ChangePassword()
    {
    	
    }
    
    
    public void assignDoctor() 
    {
    	
    }
    public void billpayment() {}
    public void Givefeedback() {}//feedback form banega
   
    
    
	
}
