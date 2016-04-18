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
import model.User;


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
		List<User> userList = new ArrayList<>();
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		String birthDate = request.getParameter("birthDate");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			switch (action) {
				
			case "ListUser":
				userList = userDAO.listUser();
				request.setAttribute("listUsers", userList);
				this.rd = request.getRequestDispatcher("usersList.jsp");
				this.rd.forward(request, response);
				break;
				
			case "CreateUser":
				user.setName(request.getParameter("name"));
				user.setLastName(request.getParameter("lastName"));
				user.setGender(request.getParameter("gender"));
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setNickname(request.getParameter("nickname"));
				
				
				Date date = (Date) formatter.parse(birthDate);
				user.setBirthDate(date);				
			
				int occurence = 0;

				
				occurence = userDAO.validateUser(user.getNickname(), user.getEmail(), occurence);
				
				if(occurence == 0){
					userDAO.createUser(user);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
				}else{
					message = "Email ou Apelido já utilizado";
					this.rd = request.getRequestDispatcher("user.jsp");
					this.rd.forward(request, response);
				}
				
				break;
			case "DeleteUser":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				String id = request.getParameter("id");
				
				userDAO.deleteUser(id);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				
			break;
			case "EditUser":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				id = request.getParameter("id");
				
				user.setName(request.getParameter("name"));
				user.setLastName(request.getParameter("lastName"));
				user.setGender(request.getParameter("gender"));
				user.setPassword(request.getParameter("password"));
				user.setNickname(request.getParameter("nickname"));
				
				Date data = (Date) formatter.parse(birthDate);
				user.setBirthDate(data);
				
				userDAO.editUser(user, id);
				this.rd = request.getRequestDispatcher("ServletAuthentication");
				this.rd.forward(request, response);
				
				break;
			
			case "ListProfile":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				id = request.getParameter("id");
				user = userDAO.showUserProfile(id);
				request.setAttribute("user", user);
				this.rd = request.getRequestDispatcher("editUser.jsp");
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
