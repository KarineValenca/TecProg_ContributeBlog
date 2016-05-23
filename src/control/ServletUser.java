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

		try{
			switch(action){
			// this case is used to list all registered users
			case "ListUser":
				List<User> userList = new ArrayList<>();
				UserDAO userDAOList = new UserDAO();

				userList = userDAOList.listUser();
				request.setAttribute("listUsers", userList);

				this.rd = request.getRequestDispatcher("usersList.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to show the user profile
			case "ListProfile":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				String id = request.getParameter("id");
				User user = new User();
				UserDAO userDAOProfile = new UserDAO();

				user = userDAOProfile.showUserProfile(id);

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

		try {
			switch (action) {
			// this case is used to allow the user to create an account
			case "CreateUser":
				User userCreate = new User();

				userCreate.setName(request.getParameter("name"));
				userCreate.setLastName(request.getParameter("lastName"));
				userCreate.setGender(request.getParameter("gender"));
				userCreate.setEmail(request.getParameter("email"));
				userCreate.setPassword(request.getParameter("password"));
				userCreate.setNickname(request.getParameter("nickname"));

				// getting date from view and converting to correct format
				String birthDateCreate = request.getParameter("birthDate");
				DateFormat formatterCreate = new SimpleDateFormat("yyyy-MM-dd");
				Date date = (Date) formatterCreate.parse(birthDateCreate);
				userCreate.setBirthDate(date);

				int validadeUser = 0;
				String nickname = userCreate.getNickname();
				String email = userCreate.getEmail();
				UserDAO userDAO = new UserDAO();

				validadeUser = userDAO.validateUser(nickname, email, validadeUser);
				
				if(validadeUser == 0) {
					boolean wasCreated = false;
					wasCreated = userDAO.createUser(userCreate);
					
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
				UserDAO userDAODelete = new UserDAO();
				boolean wasDeleted = false;
				wasDeleted = userDAODelete.deleteUser(id);

				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);

			break;

			// this case is used to allow the user update data in their account
			case "EditUser":
				// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
				User userEdit = new User();

				userEdit.setName(request.getParameter("name"));
				userEdit.setLastName(request.getParameter("lastName"));
				userEdit.setGender(request.getParameter("gender"));
				userEdit.setPassword(request.getParameter("password"));
				userEdit.setNickname(request.getParameter("nickname"));

				String birthDateEdit = request.getParameter("birthDate");
				DateFormat formatterEdit = new SimpleDateFormat("yyyy-MM-dd");
				Date data = (Date) formatterEdit.parse(birthDateEdit);
				userEdit.setBirthDate(data);

				id = request.getParameter("id");
				UserDAO userDAOEdit = new UserDAO();
				userDAOEdit.editUser(userEdit, id);
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