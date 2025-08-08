package in.pentagon.studenrapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Login{
	 public static void login(){
		 Scanner sc=new Scanner(System.in);
		 int choice=0;
		 StudentDAO sdao=new StudentDAOImp1();
		 System.out.println("<--LOGIN PAGE-->");
		 System.out.println("Enter the mail Id:");
		 String mail=sc.next();
		 System.out.println("Enter the Password:");
		 String pass=sc.next();
		 Student a=sdao.getStudent(mail,pass);
		 if(a!=null) {
			 System.out.println("LOgin succcesfull !WelCome"+a.getName()); 
			 do {
				 System.out.println("1.View Data");
				 System.out.println("2.Search User");
				 System.out.println("3.Update Account");
				 System.out.println("4.Reset Password");
				 System.out.println("5.Back to Main Menu");
				 if(a.getId()==2) {
				 System.out.println("6.View all User");
				 System.out.println("7.Delete the User");
				 }
			 choice =sc.nextInt();
			 switch(choice) {
			 case 1:System.out.println(a);
			 break;
			 case 2:System.out.println("Ener the Student name");
			          String name=sc.next();
			          ArrayList<Student>sT=sdao.getStudent(name);
			          for(Student s3:sT) {
			        	  System.out.println("Student id: "+s3.getId());
			        	  System.out.println("Student name: "+s3.getName());
			        	  System.out.println("Student branch: "+s3.getBranch());
			        	  System.out.println("Student location: "+s3.getLoc());
			        	  System.out.println("Student phone: "+s3.getPhone());  
			          }
			          
		     break;
			 case 3:Update.update(a);
			 break;
			 case 4:Password.reset(a); 
		     break;
			 case 5:System.out.println("Going to Back to Man menu..");
			 break;
			 case 6:System.out.println("Our users..!");
			          ArrayList<Student>sL=sdao.getStudent();
			          for(Student s:sL) {
			        	  System.out.println(s);
			          }
			         	  
			 break;
			 case 7:
			 break;
			 default:System.out.println("Invalid Choice! try again");
			 }
			 }while(choice!=5);
		 }
			 else {
			 System.out.println("Failed to login!");
		 }
	 }
}

