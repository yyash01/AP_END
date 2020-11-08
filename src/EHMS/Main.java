package EHMS;
import EHMS.ConnectionProvider;
import java.sql.*;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("\n\t******************************E-HealthCare-Management-Sytem***********************************\n");
		boolean check = false;
		Scanner sc=new Scanner(System.in);
		Admin a=new Admin();
		Patients p=null;
		Doctor d=null;
		while(true)
		{
	        System.out.print("\t**********************************************************************************************\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  1. ADMIN - LOGIN                                                          *\n");
	        System.out.print("\t*                  2. PATIENT - LOGIN                                                        *\n");
	        System.out.print("\t*                  3. DOCTOR - LOGIN                                                         *\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  4. REGISTER - PATIENT                                                     *\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  5. EXIT                                                                   *\n");
	        System.out.print("\t**********************************************************************************************\n");	
		int choice = sc.nextInt();
		switch (choice)
		{
		    case 1:  // admins portal
		    {  
		    	boolean checkadmin = false;
		    	System.out.println("***********Welcome to Admins portal******************");
		    	String un;
		    	String pd;
		    	System.out.print("USERNAME-->");un=sc.next();
		    	System.out.print("Password-->");pd=sc.next();
		    	if((un.compareTo("Siddharth")==0&&pd.compareTo("1234")==0)||(un.compareTo("Yash")==0&&pd.compareTo("1234")==0))
		    	{
		    		while(true)
		    		{
		    			System.out.println("\n\t1.DoctorsList\n\t2.PatientsList.\n\t3.AddDoctor\n\t4.RemoveDoctor\n\t5.AppointmentsDetail\n\t6.updateDoctorsdetails\n\t7.LOGOUT");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					a.viewDoctors();
		    					break;
		    				}
		    				case 2:
		    				{
		    					a.viewPatients();
		    					break;
		    				}
		    				// case 3:
		    				// {
		    				// 	int id=a.addPatient();
		    			    // 	p=new Patients();
		    				// 	p.PatientRegistration(id);
		    				// 	break;
		    				// }
		    				case 3:
		    				{
		    					int Id=a.addDoctor();
		    					d=new Doctor();
		    					d.DoctorRegistration(Id);
		    					break;
		    				}
//		    				case 5:
//		    				{
//		    					System.out.println("Enter doctorID!!");
//		    					int id=sc.nextInt();
//		    					a.RemoveDoctor(id);
//		    					break;
//		    				}
		    				case 4:
		    				{
		    					System.out.println("Enter doctorID!!");
		    					int id=sc.nextInt();
		    					a.RemovePatient(id);
		    					break;
		    				}
		    				case 5:
		    				{
	    					  //AppointmentsDetail
		    					break;
		    				}
		    				//case-8 was paymentDetail -> we will fix price of each doctor => 500/- okay.
		    				case 6:
		    				{
		    					//updateDoctorsdetails
		    					break;
		    				}
		    				case 7:
		    				{
		    					checkadmin = true;
		    					break;
		    					
		    				}
		    			}//end of switch
		    			if(checkadmin)
		    				break;
		    		}//end of while
		    		
		    	}
		    	else
		    		System.out.println("Invalid username or password");
		    	break;
		    }
		    case 2:   //For Patient   
		    {
		    	boolean checkPatient = false;
		    	int flag=0;
		    	System.out.println("*****************Welcome to patient portal***********************");
		    	String un;
		    	String pd;
		    	String userType="Patient";
		    	System.out.print("USERNAME:");un=sc.next();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd");
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.ViewProfile\n 2.viewDoctors.\n3.BookAppointments\n4.CancelAppointment\n5.PayBill\n6.ViewReport\n7.view Appointments\n.ChangePassword\n.Logout");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					
		    				}
		    				case 2:
		    				{
		    					
		    				}
		    				case 3:
		    				{
		    					System.out.println("Enter your Problem!!!");
		    					
		    				}
		    				case 4:
		    				{
		    					
		    				}
		    				case 5:
		    				{
		    					
		    				}
		    				case 6:
		    				{
		    					
		    				}
		    				case 7:
		    				{
		    					
		    				}
		    				case 8:
		    				{
		    					checkPatient = true;
		    					break;
		    				}
		    			}
		    			if(checkPatient)
		    				break;
		    		}//end of while
		    	}
		    	break;
		    }
		    case 3: //For Doctor
		    {
		    	boolean checkDoctor = false;
		    	System.out.println("Welcome to Doctors portal");
		    	int flag=0;
		    	String un;
		    	String pd;
		    	String userType="Doctor";
		    	System.out.print("USERNAME:");un=sc.next();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd");
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.View profile\n 2.viewAppointments.\n3.Cancel Appointments\n4.\n5.\n6.\n7.view Appointments\n.8Logout");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    			
		    				}
		    				case 2:
		    				{
		    					
		    				}
		    				case 3:
		    				{
		    					
		    				}
		    				case 4:
		    				{
		    					
		    				}
		    				case 5:
		    				{
		    					
		    				}
		    				case 6:
		    				{
		    					
		    				}
		    				case 7:
		    				{
		    					
		    				}
		    				case 8:
		    				{
		    					checkDoctor = true;
		    					break;
		    				}
		    			}//end of switch.
		    			if(checkDoctor)
		    				break;
		    		}//end of while
		    	}
		    	break;
		    	
		    }
		    case 4:   //registration of Patient
		    {
		    	
		    	
		    	break;
		    }
		    case 5:
		    {
		    	System.out.println("**THANKS FOR VISITING US - Have A Nice Day**");
		    	check = true;
		    	break;
		    }
		    default :
		    {
		    	System.out.println("** PLEASE CHOOSE AN OPTION **");
		    }
		}//end of switch
		if(check)
			break;
		}//end of while loop

	}

}
