/*
 * Class file: ServletPublication.java
 * Purpose of class: This file contains the ServletPublication class and its methods.
 * Copyright: This software follows GPL license.
 */

package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.PublicationDAO;
import model.Blog;
import model.Comment;
import model.Publication;

/**
 * Class name: ServletPublication
 * Purpose of class: This used to the methods create, list, include, delete, rate, edit and
 * show list comments.
 **/
@WebServlet("/ServletPublication")
public class ServletPublication extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	/**
	 * Method name: doGet
	 * Purpose of method: This method is used to intercept HTTP GET requests.
	 * The HTTP GET requests are used when you get the same result everytime.
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application.
	 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse
		                       response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Method name: doPost
	 * Purpose of method: This method is used to intercept HTTP POST requests.
 	 * The HTTP POST request are used when the results of the requests will
  	 * not be the same.
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application.
	 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse
		                        response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Publication publication = new Publication();
		PublicationDAO publicationDAO = new PublicationDAO();
		Blog blog = new Blog();
		List<Comment> listComments = new ArrayList();
		CommentDAO commentsDAO = new CommentDAO();

		try{
			switch(action){
			// this case is used for the User to create a publication in a blog
			case "CreatePublication":
				int idBlogInsert = ( Integer.parseInt(request.getParameter("idBlog")));

				publication.setTitlePublication(request.getParameter("titlePublication"));
				publication.setCategoryPublication(request.getParameter("categoryPublication"));
				publication.setContentPublication(request.getParameter("contentPublication"));
				publicationDAO.createPublication(idBlogInsert, publication);

				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to create an object of publication and instantiates it
			case "PublicationInstance":
				String idBlog = request.getParameter("idBlog");

				request.setAttribute("idBlog", idBlog);

				this.rd = request.getRequestDispatcher("createPublication.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to allow the user update data in their publication
			case "EditPublication":
				String idPublication = request.getParameter("idPublication");

				publication.setTitlePublication(request.getParameter("titlePublication"));
				publication.setCategoryPublication(request.getParameter("categoryPublication"));
				publication.setContentPublication(request.getParameter("contentPublication"));

				publicationDAO.editPublication(publication, idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to show the all publications
			case "ListPublication":
				idPublication = request.getParameter("idPublication");
				publication = publicationDAO.listPublication(idPublication);

				request.setAttribute("publicacao", publication);

				this.rd = request.getRequestDispatcher("editPublication.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to allow the user delete their publication
			case "DeletePublication":
				idPublication = request.getParameter("idPublication");
				publicationDAO.deletePublication(idPublication);

				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used for a User to rate a publication
			case "RatePublication":
				String gradePublication = request.getParameter("gradePublication");
				int currentRate = publication.getGradePublication();
				int endRate = currentRate+Integer.parseInt(gradePublication);
				idPublication = request.getParameter("idPublication");

				publication.setGradePublication(endRate);
				publicationDAO.ratePublication(publication, gradePublication, idPublication);

				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to show the all comments about publication
			case "ListComments":
				idPublication = request.getParameter("idPublication");
				listComments = publicationDAO.listComents(idPublication);

				request.setAttribute("listaComentariosPublicacao", listComments);

				this.rd = request.getRequestDispatcher("listarComentariosPublicacao.jsp");
				this.rd.forward(request, response);
				break;
			}
		}
		catch(Exception e){
			// TODO: handle exception
		}
	}
}
