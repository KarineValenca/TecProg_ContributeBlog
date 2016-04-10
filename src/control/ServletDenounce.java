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

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import dao.BlogDAO;
import dao.DenunciaBlogDAO;
import dao.DenunciaPublicacaoDAO;
import dao.FabricaDenunciaBlogDAO;
import dao.FabricaDenunciaPublicacaoDAO;
import model.Blog;
import model.Denuncia;
import model.DenunciaBlog;
import model.DenunciaPublicacao;
import model.User;

@WebServlet("/ServletDenuncia")
public class ServletDenuncia extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		DenunciaBlog denunciaBlog = new DenunciaBlog();
		DenunciaPublicacao denunciaPublicacao = new DenunciaPublicacao();
		FabricaDenunciaBlogDAO fabricaDenunciaBlogDAO = new FabricaDenunciaBlogDAO();
		DenunciaBlogDAO denunciaBlogDAO = new DenunciaBlogDAO();
		FabricaDenunciaPublicacaoDAO fabricaDenunciaPublicacaoDAO = new FabricaDenunciaPublicacaoDAO();
		DenunciaPublicacaoDAO denunciaPublicacaoDAO = new DenunciaPublicacaoDAO();
		User utilizador = new User();
		Blog blog = new Blog();
		List<Denuncia> listaDenunciaBlog = new ArrayList<>();
		List<Denuncia> listaDenunciaPublicacao = new ArrayList<>();
		
		
		try{
			switch(acao){
			case "CriarDenunciaBlog":
				denunciaBlog.setConteudoDenuncia(request.getParameter("conteudoDenuncia"));
				System.out.println(request.getParameter("conteudoDenuncia"));
				utilizador.setId(Integer.parseInt(request.getParameter("idUtilizador")));
				int idBlog = Integer.parseInt(request.getParameter("idBlog"));
				fabricaDenunciaBlogDAO.criarDenuncia(idBlog, denunciaBlog, utilizador);
				
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;
			
			
			case "InstanciaBlog":
				String idBlogD= request.getParameter("idBlog");
				request.setAttribute("idBlog", idBlogD);
				this.rd = request.getRequestDispatcher("denunciarBlog.jsp");
				this.rd.forward(request, response);
				break;
			
		
			case "CriarDenunciaPublicacao":
				denunciaPublicacao.setConteudoDenuncia(request.getParameter("conteudoDenuncia"));
				System.out.println(denunciaPublicacao.getConteudoDenuncia());
				utilizador.setId(Integer.parseInt(request.getParameter("idUtilizador")));
				int idPublicacao = Integer.parseInt(request.getParameter("idPublicacao"));
				fabricaDenunciaPublicacaoDAO.criarDenuncia(idPublicacao, denunciaPublicacao, utilizador);
				
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;
				
			case "InstanciaPublicacao":
				String idPublicacaoD= request.getParameter("idPublicacao");
				request.setAttribute("idPublicacao", idPublicacaoD);
				this.rd = request.getRequestDispatcher("denunciarPublicacao.jsp");
				this.rd.forward(request, response);
				break;
			
			
			case "ListarDenuncia":
				listaDenunciaBlog = denunciaBlogDAO.listarDenuncia();
				request.setAttribute("listaDenunciaBlog", listaDenunciaBlog);
				
				listaDenunciaPublicacao = denunciaPublicacaoDAO.listarDenuncia();
				request.setAttribute("listaDenunciaPublicacao", listaDenunciaPublicacao);
				
				this.rd = request.getRequestDispatcher("listarDenuncia.jsp");
				this.rd.forward(request, response);
				
			case "ExcluirDenunciaBlog":
				String idDenuncia = request.getParameter("idDenuncia");				
				denunciaBlogDAO.excluirDenuncia(idDenuncia);
				
				
				
				this.rd.forward(request, response);
				
			break;
			
			case "ExcluirDenunciaPublicacao":
				
				idDenuncia = request.getParameter("idDenuncia");
				
								
				denunciaPublicacaoDAO.excluirDenuncia(idDenuncia);
				this.rd = request.getRequestDispatcher("ServletDenuncia?acao=ListarDenuncia");
				this.rd.forward(request, response);
				
			break;
			
			case "ExcluirBlogDenuncia":
				System.out.println("Excluir");
				idDenuncia = request.getParameter("idDenuncia");
				System.out.println(idDenuncia);
				DenunciaBlogDAO denunciaDAO = new DenunciaBlogDAO();
				
					BlogDAO blogDao = new BlogDAO();
		
				
				Denuncia denuncia = denunciaDAO.pesquisaBlogDenuncia(idDenuncia);
				
				//System.out.println(denuncia.getIdBlog());
				System.out.println(denuncia.getConteudoDenuncia());
				
				
				System.out.println("Aint"+denuncia.getIdBlog());
				
				
				
				blogDao.excluir( String.valueOf(denuncia.getIdBlog()));
				
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				
			break;
		}
			
	}
		catch(Exception e){
			// TODO: handle exception)
		}
	  }
		
	}

