package EHMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Doctor extends Person
{
	int docid;
	String Doctor_Type,Qualification;
	int Entry_Charge;
	Scanner sc=new Scanner(System.in);
	public void DoctorRegistration(int docid)
	{
		
		super.UserInformation();
		this.docid = docid;
    	System.out.println("Entry_Charges : ");
    	Entry_Charge=sc.nextInt();
    	System.out.println("Qualification : ");
    	Qualification=sc.next();
    	System.out.println("Choose Doctor_Type From below List:");
		System.out.print("\t**********************************************************************************************\n");
        System.out.print("\t*                                                                                            *\n");
        System.out.print("\t*                    1.Eye_Specialist                                                        *\n");
        System.out.print("\t*                    2.EAR_Specialist                                                        *\n");
        System.out.print("\t*                    3.Heart_Specialist                                                      *\n");
        System.out.print("\t*                    4.Bones_Specialist                                                      *\n");
        System.out.print("\t*                    5.Lungs_Specialist                                                      *\n");
        System.out.print("\t*                    6.Kidney_Specialist                                                     *\n");
        System.out.print("\t*                    7.General_Phsysicist                                                    *\n");
        System.out.print("\t*                                                                                            *\n");
        System.out.print("\t**********************************************************************************************\n");	
        int ch = sc.nextInt();
        switch(ch)
		{
			case 1:
			{
				Doctor_Type="Eyes";
				break;
			}
			case 2:
			{
				Doctor_Type="Ear";
				break;
			}
			case 3:
			{
				Doctor_Type="Heart";
				break;
			}
			case 4:
			{
				Doctor_Type="Bone";
				break;
			}
			case 5:
			{
				Doctor_Type="Lungs";
				break;
			}
			case 6:
			{
				Doctor_Type="Kidney";
				break;
			}
			case 7:
			{
				Doctor_Type = "General_Phsysicist ";
				break;
			}
			default :
		    {
		    	System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
		    }
				
		}
    	Register reg=new Register();
    	reg.doctor_Registration(docid,First_Name,Last_Name,Gender,CN,age,Entry_Charge,Qualification,Doctor_Type,Email_Address);
	}

	public void ShowDoctorDetails(int d)
	{
		try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from Doctors where DoctorID="+d);
    		while(rs.next())
    		{
    			//yash 
    			System.out.println("DoctorID: "+rs.getInt(1));
    			System.out.println("Name: "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println("Qualification "+rs.getString(8));
    			System.out.println("Department "+rs.getString(9));
    			System.out.println("Contact No: "+rs.getString(5));
    			System.out.println("EmailId: "+rs.getString(10));
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
	public void viewAppointment(int docid)
	{
		int t=0;
		try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from  Appointments where DoctorID="+docid);
    		while(rs.next())
    		{
    			t++;
    			System.out.println("\t*** APPOINTMENT - NUMBER : "+t);
				System.out.print("\t* Appointment_ID : "+rs.getInt(1)+"                          \n");
				System.out.print("\t* Problem  :       "+rs.getString(2)+"                       \n");
				System.out.print("\t* PatientId :      "+rs.getInt(3)+"                          \n");
				System.out.print("\t* DoctorFees :     "+rs.getString(8)+"                       \n");
				System.out.print("\t* PaymentStatus :  "+rs.getString(9)+"                       \n");
				System.out.print("\t*************************************************************\n");	
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
	public void viewPatient()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Patients");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}    
	}
	public void viewDoctor()  //to view all doctors availaible in Hospital
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
	public void DiagonistPatient(int id)
	{
		System.out.println("Enter the Appointment_Id of the patient which you want to check!!");
		int appid=sc.nextInt();
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeQuery("Select * from Appointment where AppointmentID="+appid+" and Payment_Status='Payed' and Appointment_Status='Pending'");
			Report rp=new Report();
			rp.DiagonistReport(id,appid,docid);  //idhr error aa skti hai sayhad .... id vala glt hoga sice hmne entry as parameter (int id) liya hai jo ki doctorid bta ti hai.....
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
}
