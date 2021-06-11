package devops.cap.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.cap.model.User;
import devops.cap.service.UserService;

public class UserPasswordController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String newpass = request.getParameter("newpassword");
		String confirmpass = request.getParameter("confirmpassword");
		String email = request.getParameter("email");

		
			if (newpass.equals(confirmpass)) {

				User updatePwd = new User("", "", newpass, email);

				if (new UserService().updatePassword(updatePwd)) {
					
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					PrintWriter pout= response.getWriter();
					out.write("password updated for user");
					rd.include(request, response);
				}
				
			}
			else
				{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					PrintWriter pout= response.getWriter();
					out.write("password doesnt matches");
					rd.include(request, response);	
				}


			
		}
	}

