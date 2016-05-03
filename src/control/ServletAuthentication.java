/**
 * File name: ServletAuthenticacion.java 
 * Purpose of file: This file contains the ServletAuthentication class and its
 * methods.
 * Copyright: This software follows GPL license.
 **/

package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AuthenticationDAO;
import model.User;

/**
 * Class name: ServletAuthentication
 * Purpose of class: This class is used to authorize a user at the system.
 **/
@WebServlet("/ServletAuthentication")
public class ServletAuthentication extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private String email = "Not authorized";
	private String password = "Not authorized";
	
	public ServletAuthentication(){
		super();
	}
	
	/**
	 * Method name: doPost
	 * Purpose of method: This method is used to intercept HTTP POST requests. 
 -	 * The HTTP POST request are used when the results of the requests will
  	 * not be the same. 
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application. 
	 * @return: there is no return
	 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse 
							response) throws ServletException, IOException {
		this.email = request.getParameter("email");
		assert(email != null) : "Unexpected error: the email is receiving null from view";
		
        this.password = request.getParameter("password");
        assert(password != null) : "Unexpected error: the password is receinving null from view";
               
        AuthenticationDAO authenticacaoDAO = new AuthenticationDAO(); 
        User user = new User();
        
        user = authenticacaoDAO.authenticateUser(this.email, this.password);
        
        boolean autorization = verifyUser(user);
        
        if(autorization==true) {
        	this.rd = request.getRequestDispatcher("userAdministrationPanel.jsp");
        	request.getSession().setAttribute("user", user);
        	this.rd.forward(request, response);
        }
        else {
        	this.rd = request.getRequestDispatcher("index.jsp");
        	this.rd.forward(request, response);
        }        
	}
	
	/**
	 * Method name: verifyUser
	 * Purpose of method: This method is used to verify if the email is 
	 * authorized, if it is authorized, returns true
	 * @param user: This is an object of User type that is used to verify if the
	 * userEmail is authorized.
	 * @return: true if the email is authorized, false if the email is not
	 * authorized.
	 **/
	public boolean verifyUser(User user) {
		assert(user != null) : "Unexpected error: the object user is null";
		
		String userEmail = user.getEmail();
		
		if(userEmail != "Not authorized" ) {
			return true;
		}
		else{
			return false;
		}
	}
	
}
