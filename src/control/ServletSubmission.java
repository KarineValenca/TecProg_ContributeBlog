/** 
 * File name: ServletSubmission.java
 * Purpose of file: this file contains the ServletSubmission class and its methods.   
 * Copyright: This software follows GPL license.
 */

package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import model.Publication;
import model.CollaborativePublication;
import dao.CollaborationDAO;
import dao.CommentDAO;

/**
 * Class name: ServleSubmission
 * Purpose of class: This class is responsible for implementation of submission 
 * of publication post, create collaboration, approve publication, accept 
 * publication and list comments.
 */
@WebServlet("/ServletSubmission")
public class ServletSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CollaborationDAO subDAO = new CollaborationDAO();
	CollaborativePublication pubCollaborative = new CollaborativePublication();
	private RequestDispatcher rd;

	/** 
	 * Method name: doGet
	 * Purpose of method: this method is used to intercept HTTP GET requests. 
	 * The HTTP GET requests are used when you get the same result everytime 
	 * you execute the request.  
	 * @param request: used to represent the HTTP request that a browser sends
	 * to the application.
	 * @param response: used to represent the HTTP response that the application
	 * sends to a browser. 
	 * @return there is no return.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		String action = request.getParameter("action");
		System.out.println(action);
		
		try{
			switch(action){
			//implementation of list comments	
			case "ListComment":
				CommentDAO commentDAO = new CommentDAO();
				String idPost = request.getParameter("idPost");
				List<Comment> comment = commentDAO.listBlogComment(idPost);
				request.setAttribute("comentarios", comment);				
				this.rd = request.getRequestDispatcher("deleteComment.jsp");
				this.rd.forward(request, response);
			default:
				// nothing to do
				break;

			}
		}
			catch(Exception e){
				// TODO: handle exception
			}
		doPost(request, response);
		
	}

	/** 
	 * Method name: doPost
	 * Purpose of method: this method is used to intercept HTTP POST requests. 
	 * The HTTP POST request are used when the results of the requests will 
	 * not be the same.  
	 * @param request: used to represent the HTTP request that a browser sends
     * to the application.
	 * @param response: used to represent the HTTP response that the application
     * sends to a browser. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						  throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		List<Publication> list= new ArrayList<>();
		String action = request.getParameter("action");
		System.out.println(action);
		int idBlog = 0;

		try {
			switch (action) {
				//implementation of post submission
				case "SubmissionPost":
					idBlog = Integer.parseInt(request.getParameter("idBlog"));
					System.out.println(request.getParameter("idBlog"));
					pubCollaborative.setCategoryPublication(request.
							getParameter("categoryPublication"));
					System.out.println(request.getParameter("category"
							+ "Publication"));
					pubCollaborative.setContentPublication(request.
							getParameter("contentPublication"));
					System.out.println(request.getParameter("content"
							+ "Publication"));
					pubCollaborative.setTitlePublication(request.getParameter("title"
							+ "Publication"));
					System.out.println(request.getParameter("titlePublication"));
					subDAO.createPublication(idBlog, pubCollaborative);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of the create of collaboration
				case "CreateCollaboration":
					System.out.println(request.getParameter("idBlog"));
					request.setAttribute("idBlog", request.getParameter("idBlog"));
					this.rd = request.getRequestDispatcher("collaborative"
							+ "Publication.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of the approve of publication
				case "ApprovePublication":
					idBlog = Integer.parseInt(request.getParameter("idBlog")) ;
					list = subDAO.listCollaborationApprove(idBlog);
					System.out.println("Lista Colaborativa "+ list);
					request.setAttribute("listPublicationBlog",list);
					this.rd = request.getRequestDispatcher("approve"
							+ "Collaboration.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of the accept of publication	
				case "AcceptPublication":
					idBlog = Integer.parseInt(request.getParameter("idBlog")) ;
					pubCollaborative.setIdPublication( Integer.parseInt(request.
							getParameter("idPublication")));
					pubCollaborative.setTitlePublication(request.getParameter(""
							+ "titlePublication"));
					pubCollaborative.setCategoryPublication(request.getParameter
							(request.getParameter("categoryPublication")));
					pubCollaborative.setContentPublication(request.getParameter
							(request.getParameter("contentPublication")));
					subDAO.ApprovePublication(idBlog, pubCollaborative);
					System.out.println("aprovar");
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of list comment
					
				default:
					// nothing to do
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}