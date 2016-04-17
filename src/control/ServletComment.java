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

@WebServlet("/ServletComment")
public class ServletComment extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		
		String action = request.getParameter("action");
		
		Comment comment = new Comment();
		CommentDAO commentDAO = new CommentDAO();
		User user = new User();
		Publication publication = new Publication();
		java.util.List<Comment> comments = new ArrayList<Comment>();
		
		try {
			switch (action) {
			
			case "Create":
				comment.setCommentContent(request.getParameter("commentContent"));
				user.setId(Integer.parseInt(request.getParameter("idUser")));
				int idPublicationCreate = (Integer.parseInt(request.getParameter("idPublication")));
				
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
				String idBlog = request.getParameter("idBlog");
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
