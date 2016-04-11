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
import dao.PublicacaoDAO;
import model.Blog;
import model.Comment;
import model.Publication;

@WebServlet("/ServletPublicacao")
public class ServletPublicacao extends HttpServlet{

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
		PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
		Blog blog = new Blog();
		List<Comment> listaComentarios = new ArrayList();
		CommentDAO comentariodao = new CommentDAO();

		try{
			switch(acao){


			case "Incluir":
				publicacao.setTituloPublicacao(request.getParameter("tituloPublicacao"));
				publicacao.setCategoriaPublicacao(request.getParameter("categoriaPublicacao"));
				publicacao.setConteudoPublicacao(request.getParameter("conteudoPublicacao"));
				int idBlogInsert =( Integer.parseInt(request.getParameter("idBlog")));

				publicacaoDAO.publicar(idBlogInsert, publicacao);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;
			case "InstanciaPublicacao":
				String idBlog = request.getParameter("idBlog");
				request.setAttribute("idBlog", idBlog);
				this.rd = request.getRequestDispatcher("criarPublicacao.jsp");
				this.rd.forward(request, response);
				break;

			case "EditarPublicacao":
				String idPublication = request.getParameter("idPublication");

				publicacao.setTituloPublicacao(request.getParameter("tituloPublicacao"));
				publicacao.setCategoriaPublicacao(request.getParameter("categoriaPublicacao"));
				publicacao.setConteudoPublicacao(request.getParameter("conteudoPublicacao"));

				publicacaoDAO.editarPublicacao(publicacao, idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);

				break;

			case "ListarPublicacao":
				idPublication = request.getParameter("idPublication");
				publicacao = publicacaoDAO.listar(idPublication);
				request.setAttribute("publicacao", publicacao);
				this.rd = request.getRequestDispatcher("editarPublicacao.jsp");
				this.rd.forward(request, response);
				break;

			case "ExcluirPublicacao":
				idPublication = request.getParameter("idPublication");
				publicacaoDAO.excluirPublicacao(idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "AvaliarPublicacao":
				idPublication = request.getParameter("idPublication");
				String notaPublicacao = request.getParameter("notaPublicacao");
				int notaAtual = publicacao.getNota();
				int notaFinal = notaAtual+Integer.parseInt(notaPublicacao);
				publicacao.setNota(notaFinal);
				publicacaoDAO.avaliarPublicacao(publicacao, notaPublicacao, idPublication);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "ListarComentarios":
				idPublication = request.getParameter("idPublication");
				listaComentarios = publicacaoDAO.listarComentarios(idPublication);
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
