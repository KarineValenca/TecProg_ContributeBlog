package control;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Utilizador;


@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		//String destino = "sucesso.jsp";
		String message = "";
		List<Utilizador> userList = new ArrayList<>();
		UserDAO userDAO = new UserDAO();
		Utilizador user = new Utilizador();
		
		String birthDate = request.getParameter("dataNascimento");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			switch (action) {
				
			case "ListUser":
				userList = userDAO.listUser();
				request.setAttribute("listaUtilizador", userList);
				this.rd = request.getRequestDispatcher("listarUtilizadores.jsp");
				this.rd.forward(request, response);
				break;
			case "CreateUser":
				user.setNome(request.getParameter("nome"));
				user.setSobrenome(request.getParameter("sobrenome"));
				user.setGenero(request.getParameter("genero"));
				user.setEmail(request.getParameter("email"));
				user.setSenha(request.getParameter("senha"));
				user.setApelido(request.getParameter("apelido"));
				
				
				Date date = (Date) formatter.parse(birthDate);
				user.setDataNascimento(date);				
			
				int occurence = 0;

				
				occurence = userDAO.validateUser(user.getApelido(), user.getEmail(), occurence);
				
				if(occurence == 0){
					userDAO.createUser(user);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
				}else{
					message = "Email ou Apelido já utilizado";
					this.rd = request.getRequestDispatcher("utilizador.jsp");
					this.rd.forward(request, response);
				}
				
				break;
			case "DeleteUser":
				String id = request.getParameter("id");				
				userDAO.deleteUser(id);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				
			break;
			case "EditUser":
				id = request.getParameter("id");
				
				user.setNome(request.getParameter("nome"));
				user.setSobrenome(request.getParameter("sobrenome"));
				user.setGenero(request.getParameter("genero"));
				user.setSenha(request.getParameter("senha"));
				user.setApelido(request.getParameter("apelido"));
				
				Date data = (Date) formatter.parse(birthDate);
				user.setDataNascimento(data);
				
				userDAO.editUser(user, id);
				this.rd = request.getRequestDispatcher("ServletAuthentication");
				this.rd.forward(request, response);
				
				break;
			
			case "ListProfile":
				id = request.getParameter("id");
				user = userDAO.showUserProfile(id);
				request.setAttribute("utilizador", user);
				this.rd = request.getRequestDispatcher("editarUtilizador.jsp");
				this.rd.forward(request, response);
				
			case "SubmeterPostagem":
				/*
				 * Pegar o Id do Blog e o id do usuário 
				 * e cria uma solicitação de postagem que vai ser aprovada pelo Dono do blog.
				 * Tabela Blog tem varias ou nenhuma postagem submetidas
				 * Criar tabela de postagens Submetidas com o indice do blog
				 * Criar função para Adicionar postatgemSubmetida ao blog
				 * Adicionar postagem submetida a postagem do BLog
				 * Lista todas as postagens do blog incluindo as submetidas
				 * 
				 * 
				 * */	
				
				
				
			default:
				break;
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}			
		
	
	
}
