/**
 * File name: ServletUser.java 
 * Purpose of file: This file contains the ServletUser class and its
 * methods.
 * Copyright: This software follows GPL license.
 **/

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

/**
 * Class name: ServletUser
 * Purpose of class: This class is used to the methods list, include, delete,
 * edit and show related with user.
 **/
@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	/**
	 * Method name: doGet
	 * Purpose of method: This method is used to intercept HTTP GET requests.
	 * The HTTP GET requests are used when you get the same result everytime. 
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application. 
	 * @return: there is no return
	 **/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		UserDAO userDAO = new UserDAO();
		
		try{
			switch(action){
			// this case is used to list all registered users
			case "ListUser":
				List<User> userList = new ArrayList<>();
				userList = userDAO.listUser();
				request.setAttribute("listUsers", userList);

				this.rd = request.getRequestDispatcher("usersList.jsp");
				this.rd.forward(request, response);
				break;
				
			// this case is used to show the user profile
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

	/**
	 * Method name: doPost
	 * Purpose of method: This method is used to intercept HTTP POST requests. 
 -	 * The HTTP POST request are used when the results of the requests will
  	 * not be the same. 
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application. 
	 * @return: there is no return
	 **/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		UserDAO userDAO = new UserDAO();
		User user = new User();
		String birthDate = request.getParameter("birthDate");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			switch (action) {
			// this case is used to allow the user to create an account
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
			
			// this case is used to allow the user delete their account
			case "DeleteUser":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				String id = request.getParameter("id");

				userDAO.deleteUser(id);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);

			break;
			
			// this case is used to allow the user update data in their account
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
			
			// TODO: this method is incomplete
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
