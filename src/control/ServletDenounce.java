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
import dao.DenounceBlogDAO;
import dao.DenouncePublicationDAO;
import dao.FactoryDenounceBlogDAO;
import dao.FactoryDenouncePublicationDAO;
import model.Blog;
import model.Denounce;
import model.DenounceBlog;
import model.DenouncePublication;
import model.User;

@WebServlet("/ServletDenounce")
public class ServletDenounce extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		DenounceBlog denounceBlog = new DenounceBlog();
		DenouncePublication denouncePublication = new DenouncePublication();
		FactoryDenounceBlogDAO factoryDenounceBlogDAO = new FactoryDenounceBlogDAO();
		DenounceBlogDAO denounceBlogDAO = new DenounceBlogDAO();
		FactoryDenouncePublicationDAO factoryDenouncePublicationDAO = new FactoryDenouncePublicationDAO();
		DenouncePublicationDAO denouncePublicationDAO = new DenouncePublicationDAO();
		User user = new User();
		Blog blog = new Blog();
		List<Denounce> listDenounceBlog = new ArrayList<>();
		List<Denounce> listDenouncePublication = new ArrayList<>();


		try{
			switch(action){
			case "CreateDenounceBlog":
				denounceBlog.setContentDenounce(request.getParameter("contentDenounce"));
				System.out.println(request.getParameter("contentDenounce"));
				user.setId(Integer.parseInt(request.getParameter("id")));
				int idBlog = Integer.parseInt(request.getParameter("idBlog"));
				factoryDenounceBlogDAO.createDenounce(idBlog, denounceBlog, user);

				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;


			case "InstanceBlog":
				String idBlogD= request.getParameter("idBlog");
				request.setAttribute("idBlog", idBlogD);
				this.rd = request.getRequestDispatcher("denunciarBlog.jsp");
				this.rd.forward(request, response);
				break;


			case "CreateDenouncePublication":
				denouncePublication.setContentDenounce(request.getParameter("contentDenounce"));
				System.out.println(denouncePublication.getContentDenounce());
				user.setId(Integer.parseInt(request.getParameter("id")));
				int idPublication = Integer.parseInt(request.getParameter("idPublication"));
				factoryDenouncePublicationDAO.createDenounce(idPublication, denouncePublication, user);

				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			case "InstancePublication":
				String idPublicationD= request.getParameter("idPublication");
				request.setAttribute("idPublication", idPublicationD);
				this.rd = request.getRequestDispatcher("denunciarPublicacao.jsp");
				this.rd.forward(request, response);
				break;


			case "ListDenounce":
				listDenounceBlog = denounceBlogDAO.listDenounce();
				request.setAttribute("listDenounceBlog", listDenounceBlog);

				listDenouncePublication = denouncePublicationDAO.listDenounce();
				request.setAttribute("listDenouncePublication", listDenouncePublication);

				this.rd = request.getRequestDispatcher("listarDenuncia.jsp");
				this.rd.forward(request, response);

			case "DeleteDenounceBlog":
				String idDenuncia = request.getParameter("idDenounce");
				denounceBlogDAO.deleteDenounce(idDenounce);



				this.rd.forward(request, response);

			break;

			case "DeleteDenouncePublication":

				idDenounce = request.getParameter("idDenounce");


				denouncePublicationDAO.deleteDenounce(idDenuncia);
				this.rd = request.getRequestDispatcher("ServletDenuncia?acao=ListDenounce");
				this.rd.forward(request, response);

			break;

			case "DeleteBlogDenounce":
				System.out.println("Delete");
				idDenounce = request.getParameter("idDenounce");
				System.out.println(idDenounce);
				DenounceBlogDAO denounceDAO = new DenounceBlogDAO();

					BlogDAO blogDao = new BlogDAO();


				Denounce denounce = denounceDAO.searchBlogDenounce(idDenounce);

				//System.out.println(denuncia.getIdBlog());
				System.out.println(denounce.getContentDenounce());


				System.out.println("Aint"+denounce.getIdBlog());



				blogDao.excluir( String.valueOf(denounce.getIdBlog()));

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

