package devops.cap.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.cap.model.User;
import devops.cap.service.UserService;

public class UserLoginController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		if ((email != null && email.isEmpty()) || (pass !=null && pass.isEmpty())) {
		
		
			  RequestDispatcher rd = request.getRequestDispatcher("/empty.jsp");
			  PrintWriter pout= response.getWriter();
			  pout.write("enter correct credentials");
			  rd.include(request, response);
			 } 
			else {
				
				  User signUp=new User("","",pass,email);

					PrintWriter pout= response.getWriter();
					if (new UserService().isAuthorized(signUp)) {
						pout.write("Login successfull...");
                                       RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
						
						
						rd.forward(request,response);
						return;
					}
					pout.write("Login fail...");
					 
					RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
					rd.forward(request,response);
					
					
			  }
	}

}
