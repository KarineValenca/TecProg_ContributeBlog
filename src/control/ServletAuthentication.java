/*
 * Class name: ServletUser.java
 * Purpose of class: This class is used to the methods list, include, delete,
 * edit and show related with user.
 * Copyright: This software follows GPL license.
 */

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

@WebServlet("/ServletAuthentication")
public class ServletAuthentication extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private String email = "";
	private String password = "";
	
	public ServletAuthentication(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse 
							response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse 
							response) throws ServletException, IOException {
		this.email = request.getParameter("email");
		assert(email != null) : "Unexpected error: the email is receiving null from view";
		
        this.password = request.getParameter("password");
        assert(password != null) : "Unexpected error: the password is receinving null from view";
               
        AuthenticationDAO authenticacaoDAO = new AuthenticationDAO(); 
        User user = new User();
        
        user = authenticacaoDAO.authenticateUser(this.email, this.password);
        
        boolean autorization = verifyUser(user, this.email, this.password);
        
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
	
	public boolean verifyUser(User user, String email, String password) {
		assert(user != null) : "Unexpected error: the object user is null";
		assert(email != null) : "Unexpected error: the email is receiving null";
		assert(password != null) : "Unexpected error: the password is receiving null";
		
		String userEmail = user.getEmail();
		
		if(userEmail != "" ) {
			return true;
		}
		else{
			return false;
		}
	}
	
}
