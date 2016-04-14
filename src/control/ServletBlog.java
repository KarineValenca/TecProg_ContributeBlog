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

import dao.BlogDAO;
import model.Blog;
import model.BlogOwner;
import model.Publication;




@WebServlet("/ServletBlog")
public class ServletBlog extends HttpServlet {



	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String destino = "sucesso.jsp";
		String message = "";
		List<Blog> listBlog = new ArrayList<>();
		List<Publication> listPublication = new ArrayList<>();
		BlogDAO blogdao = new BlogDAO();
		Blog blog = new Blog();
		BlogOwner ownerBlog = new BlogOwner();

		try {
			switch (action) {


			case "CreateBlog":
				blog.setTitle(request.getParameter("titulo"));
				blog.setCategorie(request.getParameter("categoria"));
				ownerBlog.setId( Integer.parseInt(request.getParameter("idDonoBlog")));


				blogdao.createBlog(blog, ownerBlog );
				this.rd = request.getRequestDispatcher("ServletDonoBlog?action=ListarDono&idOwnerBlog.jsp");
				this.rd.forward(request, response);

				break;

			case "ListBlog":
				listBlog = blogdao.listBlog();
				request.setAttribute("listaBlog", listBlog);
				this.rd = request.getRequestDispatcher("listBlogs.jsp");
				this.rd.forward(request, response);

				break;

			case "DeleteBlog":
				String idBlog = request.getParameter("idBlog");
				blogdao.deleteBlog(idBlog);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);

			break;

			case "ListPublications":

				String idBlogP =  request.getParameter("idBlog") ;
				listPublication = blogdao.listPublicationBlog(idBlogP);
				request.setAttribute("listaPublicacaoBlog", listPublication);
				this.rd = request.getRequestDispatcher("listPublication.jsp");
				this.rd.forward(request, response);

			break;

			case "ListPublicationsBlog":

				idBlogP =  request.getParameter("idBlog") ;
				listPublication = blogdao.listPublicationBlog(idBlogP);
				request.setAttribute("listaPublicacaoBlog", listPublication);
				this.rd = request.getRequestDispatcher("listPublicationsBlog.jsp");
				this.rd.forward(request, response);

			break;

			case "InstancePublication":
				String idBlogI = request.getParameter("idBlog");
				request.setAttribute("idBlog", idBlogI);
				this.rd = request.getRequestDispatcher("painelAdministrativoBlog.jsp");
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
