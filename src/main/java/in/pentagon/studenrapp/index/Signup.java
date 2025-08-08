package in.pentagon.studenrapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;
  
public class Signup {
 public static void signup() {
	 Scanner sc=new Scanner(System.in);
	 StudentDAO sado=new StudentDAOImp1();
	 
	 Student s=new Student();
	 System.out.println("<--Student Signup-->");
	 System.out.println("Enter the name:");
	 //String name=sc.next();
	 //s.setName(name);
	 s.setName(sc.next());
	 System.out.println("Enter the phone:");
	 s.setPhone(sc.nextLong());
	 
	 System.out.println("Enter the Email:");
	 s.setMail(sc.next());
	 
	 System.out.println("Enter the Branch:");
	 s.setBranch(sc.next());
	 
	   System.out.println("Enter the Location:");
	   s.setLoc(sc.next());
	   
	   System.out.println("Set new Password");
	   String password=sc.next();
	   
	   System.out.println("Confirm password");
	   String confirmpassword=sc.next();
	   if(password.equals(confirmpassword)){
		   s.setPassword(confirmpassword);
		   boolean res=sado.insertStudent(s);
		   if(res){
			   System.out.println("Data Added successfully!");
		   }
		   else {
			   System.out.println("Failed to Create Account");
		   }
	   }
	   else {
		   System.out.println("Password Mismatched");
	   }
    }
 }

