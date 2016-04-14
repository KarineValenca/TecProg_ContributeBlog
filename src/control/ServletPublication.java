package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet("/ServletPublication")
public class ServletPublication extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		Publication publicacao = new Publication();
		PublicationDAO publicacaoDAO = new PublicationDAO();
		Blog blog = new Blog();
		List<Comment> listaComentarios = new ArrayList();
		CommentDAO comentariodao = new CommentDAO();

		try{
			switch(acao){


			case "Incluir":
				publicacao.setTitlePublication(request.getParameter("titlePublication"));
				publicacao.setCategoryPublication(request.getParameter("categoryPublication"));
				publicacao.setContentPublication(request.getParameter("contentPublication"));
				int idBlogInsert =( Integer.parseInt(request.getParameter("idBlog")));

				publicacaoDAO.createPublication(idBlogInsert, publicacao);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;
			case "InstanciaPublicacao":
				String idBlog = request.getParameter("idBlog");
				request.setAttribute("idBlog", idBlog);
				this.rd = request.getRequestDispatcher("createPublication.jsp");
				this.rd.forward(request, response);
				break;

			case "EditarPublicacao":
				String idPublication = request.getParameter("idPublication");

				publicacao.setTitlePublication(request.getParameter("titlePublication"));
				publicacao.setCategoryPublication(request.getParameter("categoryPublication"));
				publicacao.setContentPublication(request.getParameter("contentPublication"));

				publicacaoDAO.editPublication(publicacao, idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);

				break;

			case "ListarPublicacao":
				idPublication = request.getParameter("idPublication");
				publicacao = publicacaoDAO.listPublication(idPublication);
				request.setAttribute("publicacao", publicacao);
				this.rd = request.getRequestDispatcher("editPublication.jsp");
				this.rd.forward(request, response);
				break;

			case "ExcluirPublicacao":
				idPublication = request.getParameter("idPublication");
				publicacaoDAO.deletePublication(idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "AvaliarPublicacao":
				idPublication = request.getParameter("idPublication");
				String gradePublication = request.getParameter("gradePublication");
				int notaAtual = publicacao.getGradePublication();
				int notaFinal = notaAtual+Integer.parseInt(gradePublication);
				publicacao.setGradePublication(notaFinal);
				publicacaoDAO.ratePublication(publicacao, gradePublication, idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "ListarComentarios":
				idPublication = request.getParameter("idPublication");
				listaComentarios = publicacaoDAO.listComents(idPublication);
				request.setAttribute("listaComentariosPublicacao", listaComentarios);
				this.rd = request.getRequestDispatcher("listarComentariosPublicacao.jsp");
				this.rd.forward(request, response);
				break;
			}


		}catch(Exception e){
			// TODO: handle exception

		}
	}
}
