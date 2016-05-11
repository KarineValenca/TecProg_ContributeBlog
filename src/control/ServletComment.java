/**
 * File name: ServletComment.java
 * Purpose of file: This file is composed by ServletComment class and methods.
 * Copyright: This software follows GPL license.
 */

package control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import dao.CommentDAO;
import model.Blog;
import model.Comment;
import model.Publication;
import model.User;

/**
 * Class name: ServletComment
 * Purpose of class: This class is responsible for, using the RequestDispatcher
 * objetc, acess the comments views pages, according to the requested action.
 */
public class ServletComment extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	/**
	 * Method name:doGet
	 * Purpose of method: This method is used to intercept HTTP GET requests. 
	 * The HTTP GET requests are used when you get the same result everytime 
	 * you execute the request.
	 * @param request Represent the HTTP request that a browser sends to the 
	 * application.
	 * @param response Represent the HTTP response that the application sends
	 * to a browser.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		
		doPost(request, response);
	}
	
	/**
	 * Method name: doPost
	 * Purpose of method: This method is used to intercept HTTP POST requests. 
	 * The HTTP POST request are used when the results of the requests will not
	 * be the same.
	 * @param request Represent the HTTP request that a browser sends to the 
	 * application.
	 * @param response Represent the HTTP response that the application sends
	 * to a browser.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		
		
		
		try {
			String action = request.getParameter("action");
			
			CommentDAO commentDAO = new CommentDAO();
			
			switch (action) {
			
			case "Create":
				Comment comment = new Comment();
				String commentContentParameter = request.getParameter("commentContent");
				comment.setCommentContent(commentContentParameter);
				
				String idUserParameter = request.getParameter("idUser");
				User user = new User();
				user.setId(Integer.parseInt(idUserParameter));
				
				String idPublicationParameter = request.getParameter("idPublication");
				int idPublicationCreate = (Integer.parseInt(idPublicationParameter));
				
				commentDAO.createComment(comment, user, idPublicationCreate);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				
				break;
				
			case "PublicationInstance":
				String idPublication = request.getParameter("idPublication");
				request.setAttribute("idPublication", idPublication);
				this.rd = request.getRequestDispatcher("createComment.jsp");
				this.rd.forward(request, response);
				break;
				
			case "ListCommentDelete":
				String idPost = request.getParameter("idPost");
				java.util.List<Comment> comments = new ArrayList<Comment>();
				comments = commentDAO.listBlogComment(idPost);
				request.setAttribute("comments", comments);
				this.rd = request.getRequestDispatcher("deleteComment.jsp");
				this.rd.forward(request, response);	
				
				break;
			case "CommentDelete":
				String idComment = request.getParameter("idComment");
				commentDAO.deleteComment(idComment);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);	
				break;
				
			default:
				break;
			}
		}catch(Exception e) {
			// TODO: handle exception)
		}
		
	}
}
