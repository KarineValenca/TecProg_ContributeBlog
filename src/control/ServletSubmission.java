package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.Comment;
import model.Publication;
import model.CollaborativePublication;
import dao.CollaborationDAO;
import dao.CommentDAO;

/**
 * Servlet implementation class ServletSubmissao
 */
@WebServlet("/ServletSubmissao")
public class ServletSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

		CollaborationDAO subDAO = new CollaborationDAO();
		CollaborativePublication pubCollaborative = new CollaborativePublication();
		private RequestDispatcher rd;
		int idBlog = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Publication> list= new ArrayList<>();
		String action = request.getParameter("action");
		System.out.println(action);


		try {
			switch (action) {

			case "SubmissionPost":
				System.out.println("Entrou");
				 idBlog = Integer.parseInt(request.getParameter("idBlog"));
				System.out.println(request.getParameter("idBlog"));
				System.out.println("Entrou1");
				String idUser = request.getParameter("idUser");
				pubCollaborative.setCategoryPublication(request.getParameter("categoryPublication"));
				System.out.println(request.getParameter("categoryPublication"));
				pubCollaborative.setContentPublication(request.getParameter("contentPublication"));
				System.out.println(request.getParameter("contentPublication"));
				pubCollaborative.setTitlePublication(request.getParameter("titlePublication"));
				System.out.println(request.getParameter("titlePublication"));
				subDAO.createPublication(idBlog, pubColaborativa);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "CreateCollaboration":
				System.out.println("Criar");
				System.out.println(request.getParameter("idBlog"));
				request.setAttribute("idBlog", request.getParameter("idBlog"));
				this.rd = request.getRequestDispatcher("collaborativePublication.jsp");
				this.rd.forward(request, response);
				break;

			case "ApprovePublication":
				idBlog = Integer.parseInt(request.getParameter("idBlog")) ;
				list = subDAO.listCollaborationApprove(idBlog);
				System.out.println("Lista Colaborativa "+ list);
				request.setAttribute("listPublicationBlog",list);
				this.rd = request.getRequestDispatcher("approveCollaboration.jsp");
				this.rd.forward(request, response);
				break;

			case "AcceptPublication":
				idBlog = Integer.parseInt(request.getParameter("idBlog")) ;
				pubCollaborative.setIdPublication( Integer.parseInt(request.getParameter("idPublication")));
				pubCollaborative.setTitlePublication(request.getParameter("titlePublication"));
				pubCollaborative.setCategoryPublication(request.getParameter(request.getParameter("categoryPublication")));
				pubCollaborative.setContentPublication(request.getParameter(request.getParameter("contentPublication")));
				subDAO.AprovarPublicacao(idBlog, pubCollaborative);
				System.out.println("aprovar");
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;
			case "ListComment":
				CommentDAO commentDAO = new CommentDAO();
				String idPost = request.getParameter("idPost");
				List<Comment> comment = commentDAO.listBlogComment(idPost);
				request.setAttribute("comentarios", comment);
				this.rd = request.getRequestDispatcher("deleteComment.jsp");
				this.rd.forward(request, response);

				break;

			default:
				break;

			}



		} catch (Exception e) {
			// TODO: handle exception
		}





	}




	}


