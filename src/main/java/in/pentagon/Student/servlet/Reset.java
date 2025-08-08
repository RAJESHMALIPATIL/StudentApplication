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
@WebServlet("/Reset")
public class Reset extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	StudentDAO sdao=new StudentDAOImp1();
	//PrintWriter out=resp.getWriter();
	Student s=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("mail"));
	if(s!=null) {
		if(req.getParameter("passsword").equals (req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.updateStudent(s);
			if (sdao.updateStudent(s)) {
				//out.println("<h1>Password Reset Successful!</h1>");
				req.setAttribute("success","Password Updated Successfully!");
				 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				 rd.forward(req, resp);
			} else {
				//out.println("<h1>Failed to Reset Password!</h1>");
				 req.setAttribute("error", "Failed to Reset Password");
				 RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
				 rd.forward(req, resp);
			}
		} else {
			//out.println("<h1>Password Mismatch!</h1>");
			 req.setAttribute("error", "Password Mismatched");
			 RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
			 rd.forward(req, resp);
		}
	} else {
		//out.print("<h1>Failed to reset Password!</h1>");
		 req.setAttribute("error", "Failed to Reset Password");
		 RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
		 rd.forward(req, resp);

		}

	}
	}
