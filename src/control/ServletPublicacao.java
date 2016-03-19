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

import dao.ComentarioDAO;
import dao.PublicacaoDAO;
import model.Blog;
import model.Comentario;
import model.Publicacao;

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
		Publicacao publicacao = new Publicacao();
		PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
		Blog blog = new Blog();
		List<Comentario> listaComentarios = new ArrayList();
		ComentarioDAO comentariodao = new ComentarioDAO();
		
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
				String idPublicacao = request.getParameter("idPublicacao");
				
				publicacao.setTituloPublicacao(request.getParameter("tituloPublicacao"));
				publicacao.setCategoriaPublicacao(request.getParameter("categoriaPublicacao"));
				publicacao.setConteudoPublicacao(request.getParameter("conteudoPublicacao"));
				
				publicacaoDAO.editarPublicacao(publicacao, idPublicacao);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				
				break;
				
			case "ListarPublicacao":
				idPublicacao = request.getParameter("idPublicacao");
				publicacao = publicacaoDAO.listar(idPublicacao);
				request.setAttribute("publicacao", publicacao);
				this.rd = request.getRequestDispatcher("editarPublicacao.jsp");
				this.rd.forward(request, response);
				break;
			
			case "ExcluirPublicacao":
				idPublicacao = request.getParameter("idPublicacao");
				publicacaoDAO.excluirPublicacao(idPublicacao);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);	
				break;
				
			case "AvaliarPublicacao":
				idPublicacao = request.getParameter("idPublicacao");
				String notaPublicacao = request.getParameter("notaPublicacao");
				int notaAtual = publicacao.getNota();
				int notaFinal = notaAtual+Integer.parseInt(notaPublicacao);
				publicacao.setNota(notaFinal);
				publicacaoDAO.avaliarPublicacao(publicacao, notaPublicacao, idPublicacao);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);	
				break;
				
			case "ListarComentarios":
				idPublicacao = request.getParameter("idPublicacao");
				listaComentarios = publicacaoDAO.listarComentarios(idPublicacao);
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
