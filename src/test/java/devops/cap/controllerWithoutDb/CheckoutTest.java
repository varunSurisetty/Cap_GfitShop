package devops.cap.controllerWithoutDb;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import devops.cap.controllerWithoutDb.UserCheckoutController;


public class CheckoutTest extends Mockito{
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 RequestDispatcher rd;
	 @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }


    @Test
    public void testLoginSuccess() throws Exception {
        when(request.getParameter("userName")).thenReturn("meera");
        when(request.getParameter("password")).thenReturn("meera");
        when(request.getRequestDispatcher("paypal.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserCheckoutController().doPost(request, response);

        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Login successfull...", result);
      
    }
    
 
 
 @Test
    public void testLoginFail() throws Exception {
        when(request.getParameter("userName")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("meera");
        when(request.getRequestDispatcher("/fail.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserCheckoutController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Invalid username or password, Please try again with valid", result);
      
    }

 @Test
    public void testLoginEmpty() throws Exception {
        when(request.getParameter("userName")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        when(request.getRequestDispatcher("/fail.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserCheckoutController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();

        assertEquals("Invalid username or password, Please try again with valid", result);
      
    }
    @Test
    public void testLoginNull() throws Exception {
        when(request.getParameter("userName")).thenReturn(null);
        when(request.getParameter("password")).thenReturn(null);
        when(request.getRequestDispatcher("/fail.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserCheckoutController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();

        assertEquals("Invalid username or password, Please try again with valid", result);
      
    }

}
