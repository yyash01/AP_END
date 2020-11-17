####################################E-Health-CareManagement-System#################################################################
create database HealthcareMangaementSystem;
use HealthcareMangaementSystem;
create table Users(
	userID int,
    userType varchar(100),
	Password varchar(100),
	primary key(userID,userType)
);

create table Patients(
	PatientID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(5),
    ContactNumber varchar(11),
    Age int ,
    EmailID varchar(20),
    BloodGroup varchar(5),
    Address varchar(50),
	primary key(PatientID)
);
select * from Patients;
create table Doctors(
	DoctorID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(10),
    ContactNumber varchar(11),
    Age int ,
    Entry_Charge int,#
    Qualification varchar(50),#Mbbs etc
    Doctor_Type varchar(50),#"1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n7.General_Physicist"
    Email_Id varchar(20),
    primary key(DoctorID)
);
select * from Doctors;
create table Appointments
(
	AppointmentID int,
    Problem varchar(50),
	PatientId int,
    DoctorName varchar(20),
    DoctorID int,
    DoctorType varchar(20),
    Qualification varchar(20),
    DoctorFees int,
    PaymentStatus varchar(33)
);


select * from Users;
insert into Users values(2,'Doctor','jain123');
insert into Users values(3,'Doctor','jain124');
drop table Users;
create table Reports
(
	ReportID int,
    appointmentID int,
    patientID int,
    DoctorID int,
    MedicinePrescribed varchar(200),
    DoctorComment varchar(200),
    billAmount int,
    status varchar(20),
    primary key (ReportID)
);
create table feedback
(
	feedbackID int not null,
	UsersName varchar(20),
    points int,
    Doc_Nature varchar(20),
    Location varchar(30),
    Feedback varchar(100)
);
select * from Users where userID=1 && userType='Patient' && Password='jain';
select * from Patients;
insert into Patients values(1, 'yash', 'jain', 'M', '234545', 12, 'yash@gmail.com', 'B', '3/436');
select * from Patients;
drop table patients;
select ContactNumber from Patients where PatientID = 1;
insert into Doctors values(1, 'DOCTOR', 'JAIN', 'M', '2323344', 34, 600, 'MSC', 'Eyes', 'docotr@gmail.com');
select * from Doctors;
select * from Doctors where DoctorID = 1;
insert into Patients values(2, 'Sidarth', 'jain', 'M', '23445545', 12, 'yash@gmffail.com', 'B', '3/436');
select * from Doctors where DoctorID = 1;
insert into Doctors values(2, 'Sid', 'JAIN', 'f', '2323344', 34, 500, 'Mbbs', 'Eyes', 'docotr_2gmail.com');
select * from Doctors;
delete  from Doctors where DoctorID = 1;
delete  from Doctors where DoctorID = 2;
Select MAX(DoctorID) as 'MaximumID' from Doctors;
select * from Doctors;
insert into Doctors values(1, 'DOCTOR', 'JAIN', 'M', '2323344', 34, 600, 'MSC', 'General', '3/436');
insert into Doctors values(2, 'Sid', 'JAIN', 'f', '2323344', 34, 500, 'Mbbs', 'General', '3/436');
select * from Doctors;
select * from Doctors where Doctor_Type = 'Eyes';
    
Select MAX(DoctorID) from Doctors;