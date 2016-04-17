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
import model.PublicacaoColaborativa;
import dao.ColaboracaoDAO;
import dao.CommentDAO;

/**
 * Servlet implementation class ServletSubmissao
 */
@WebServlet("/ServletSubmissao")
public class ServletSubmissao extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

		ColaboracaoDAO subDAO = new ColaboracaoDAO();
		PublicacaoColaborativa pubColaborativa = new PublicacaoColaborativa();
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
		List<Publication> lista= new ArrayList<>();
		String acao = request.getParameter("acao");
		System.out.println(acao);


		try {
			switch (acao) {

			case "SubmeterPostagem":
				System.out.println("Entrou");
				 idBlog = Integer.parseInt(request.getParameter("idBlog"));
				System.out.println(request.getParameter("idBlog"));
				System.out.println("Entrou1");
				String idUser = request.getParameter("idUser");
				pubColaborativa.setCategoryPublication(request.getParameter("categoryPublication"));
				System.out.println(request.getParameter("categoryPublication"));
				pubColaborativa.setContentPublication(request.getParameter("contentPublication"));
				System.out.println(request.getParameter("contentPublication"));
				pubColaborativa.setTitlePublication(request.getParameter("titlePublication"));
				System.out.println(request.getParameter("titlePublication"));
				subDAO.createPublication(idBlog, pubColaborativa);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "CriaColaboracao":
				System.out.println("Criar");
				System.out.println(request.getParameter("idBlog"));
				request.setAttribute("idBlog", request.getParameter("idBlog"));
				this.rd = request.getRequestDispatcher("PublicacaoColaborativa.jsp");
				this.rd.forward(request, response);
				break;

			case "AprovarPublicacoes":
				idBlog = Integer.parseInt(request.getParameter("idBlog")) ;
				lista = subDAO.listarColaboracaAprovar(idBlog);
				System.out.println("Lista Colaborativa "+ lista);
				request.setAttribute("listaPublicacaoBlog",lista);
				this.rd = request.getRequestDispatcher("aprovarColaboracao.jsp");
				this.rd.forward(request, response);
				break;

			case "AceitarPublicacao":
				idBlog = Integer.parseInt(request.getParameter("idBlog")) ;
				pubColaborativa.setIdPublication( Integer.parseInt(request.getParameter("idPublication")));
				pubColaborativa.setTitlePublication(request.getParameter("titlePublication"));
				pubColaborativa.setCategoryPublication(request.getParameter(request.getParameter("categoryPublication")));
				pubColaborativa.setContentPublication(request.getParameter(request.getParameter("contentPublication")));
				subDAO.AprovarPublicacao(idBlog, pubColaborativa);
				System.out.println("aprovar");
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;
			case "ListaComentario":
				CommentDAO comentarioDAO = new CommentDAO();
				String idPostagem = request.getParameter("idPostagem");
				List<Comment> comentarios = comentarioDAO.listBlogComment(idPostagem);
				request.setAttribute("comentarios", comentarios);
				this.rd = request.getRequestDispatcher("deletarComentario.jsp");
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

