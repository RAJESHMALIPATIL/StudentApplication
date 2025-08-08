package in.pentagon.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImp1();
		HttpSession session=req.getSession(true);
		//PrintWriter out = resp.getWriter();
		String username = req.getParameter("mail");
		String pass = req.getParameter("password");
		Student s = sdao.getStudent(username,pass);
// Student s = sdao.getStudent(req.getParameter("mail"),req.getParameter("password"));
		if(s != null) {
			System.out.println(s);
			//out.println("<h1>Login Successfull!...Welcome "+s.getName()+"</h1>");
			//req.setAttribute("Student", s);
			session.setAttribute("Student", s);
			req.setAttribute("success", "Login Successful!");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Login Failed..!");
			req.setAttribute("error", "Failed to Login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
			
		}
	}
}
/*	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
StudentDAO sdao=new StudentDAOImp1();
PrintWriter out = resp.getWriter();
Student s=sdao.getStudent(req.getParameter("mail"),req.getStudent("Password");
if(s!=null){
out.println("<h1>Login Successfull!...Welcome "+s.getName()+"</h1>");
}
else{
out.println("<h1>Login Failed..!");
		  }
		  }
		  }*/

