package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthenticationDAO;
import dao.UserDAO;
import model.Utilizador;

@WebServlet("/ServletAuthentication")
public class ServletAuthentication extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher rd;
	private String email = "";
	private String password = "";
	
	
	
	public ServletAuthentication(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
							IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
							IOException {
		this.email = request.getParameter("email");
        this.password = request.getParameter("password");
               
        System.out.println("hhhhhh" + this.email);
        System.out.println(this.password);
        
        AuthenticationDAO authenticacaoDAO = new AuthenticationDAO(); 
        Utilizador utilizador = new Utilizador();
        utilizador = authenticacaoDAO.authenticateUser(this.email, this.password);
        
        boolean autorization = verifyUser(utilizador, this.email, this.password);
        if(autorization==true){
        	this.rd = request.getRequestDispatcher("painelAdministrativoUsuario.jsp");
        	request.getSession().setAttribute("utilizador", utilizador);
        	this.rd.forward(request, response);
        }else{
        	this.rd = request.getRequestDispatcher("index.jsp");
        	this.rd.forward(request, response);
        }        
	}
	
	public boolean verifyUser(Utilizador utilizador, String email, String password){
	
		/*Método de verificação de Utilizador  
		 * Recebe uma instancia de utilizador 
		 * e os paramêtros de comparação 
		 * */
		
		if(utilizador.getEmail() != "" ){
			return true;
		}else{
			return false;
		}
		
	}
	
}
