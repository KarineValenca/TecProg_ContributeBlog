/*
 * Class name: ServletUser.java
 * Purpose of class: This class is used to the methods list, include, delete,
 * edit and show related with user.
 * Copyright: This software follows GPL license.
 */

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
	
	// this method do the actions that the user doesn't need to fill any data 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		UserDAO userDAO = new UserDAO();
		
		try{
			switch(action){
			case "ListUser":
				List<User> userList = new ArrayList<>();
				userList = userDAO.listUser();
				request.setAttribute("listUsers", userList);

				this.rd = request.getRequestDispatcher("usersList.jsp");
				this.rd.forward(request, response);
				break;
			case "ListProfile":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				String id = request.getParameter("id");
				id = request.getParameter("id");
				
				User user = new User();
				user = userDAO.showUserProfile(id);

				request.setAttribute("user", user);
				this.rd = request.getRequestDispatcher("editUser.jsp");
				this.rd.forward(request, response);
				break;
			}
		}
		catch(Exception e){
			
		}
	}

	// this method do the actions that the user need to fill some data
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		UserDAO userDAO = new UserDAO();
		User user = new User();
		String birthDate = request.getParameter("birthDate");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			switch (action) {
			case "CreateUser":
				user.setName(request.getParameter("name"));
				user.setLastName(request.getParameter("lastName"));
				user.setGender(request.getParameter("gender"));
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setNickname(request.getParameter("nickname"));

				Date date = (Date) formatter.parse(birthDate);
				user.setBirthDate(date);

				int validadeUser = 0;
				String nickname = user.getNickname();
				String email = user.getEmail();
				validadeUser = userDAO.validateUser(nickname, email, validadeUser);

				if(validadeUser == 0) {
					userDAO.createUser(user);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
				}
				else{
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
			case "SubmeterPostagem":
				// FIX-ME: THIS METHOD IS INCOMPLETE.
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
				break;
			default:
				break;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
