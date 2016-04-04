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

import dao.AutenticacaoDAO;
import dao.UtilizadorDAO;
import model.Utilizador;

@WebServlet("/ServletAutentication")
public class ServletAutentication extends HttpServlet{
	/**
	 * Servlet de Autenticação de Login de usuário 
	 */
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher rd;
	private String email = "";
	private String password = "";
	
	
	
	public ServletAutentication(){
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
        
        AutenticacaoDAO autenticacaoDAO = new AutenticacaoDAO(); 
        Utilizador utilizador = new Utilizador();
        utilizador = autenticacaoDAO.autenticarUtilizador(this.email, this.password);
        
        boolean autorizacao = verificarUtilizador(utilizador, this.email, this.password);
        if(autorizacao==true){
        	this.rd = request.getRequestDispatcher("painelAdministrativoUsuario.jsp");
        	request.getSession().setAttribute("utilizador", utilizador);
        	this.rd.forward(request, response);
        }else{
        	this.rd = request.getRequestDispatcher("index.jsp");
        	this.rd.forward(request, response);
        }        
	}
	
	public boolean verificarUtilizador(Utilizador utilizador, String email, String password){
	
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
