package devops.cap.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.cap.model.Cart;
import devops.cap.service.CartService;

public class UserCheckoutController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String userNm=request.getParameter("userName");
		String pass=request.getParameter("password");
		
		if (userNm.isEmpty() || pass.isEmpty()) {
			  RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
			 
			  rd.include(request, response);
			 } 
			else {
				
				  Cart signUp=new Cart(userNm,pass);

					PrintWriter pout= response.getWriter();
					if (new CartService().isAuthorized(signUp)) {
						pout.write("Login successfull...");
                                       RequestDispatcher rd=request.getRequestDispatcher("paypal.jsp");

						rd.forward(request,response);
						return;
					}
					pout.write("Login fail...");
					 
					RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
					rd.forward(request,response);
					
					
			  }
	}

}
