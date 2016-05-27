/**
 * File name: ServletBlog.java
 * Purpose of class: This file contains the ServletBlog class and its methods.
 * Copyright: This software follows GPL license.
 */

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

/**
 * Class name: ServletBlog.java
 * Purpose of class: This class is used to the methods list, create and delete, blog.
 * And some other methods such list and instance, publication.
 */
@WebServlet("/ServletBlog")
public class ServletBlog extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	/**
	 * Method name: doGet
	 * Purpose of method: This method is used to intercept HTTP GET requests.
	 * The HTTP GET requests are used when you get the same result everytime.
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse
		                 response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Method name: doPost
	 * Purpose of method: This method is used to intercept HTTP POST requests.
 	 * The HTTP POST request are used when the results of the requests will
  	 * not be the same.
	 * @param request: used to represent the HTTP request that a browser sends.
	 * @param response: used to represent the HTTP response that the application.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse
		                  response) throws ServletException, IOException {
		String action = request.getParameter("action");
		BlogDAO blogdao = new BlogDAO();

		try {
			switch (action) {
			// this case is used for the User to create a blog
			case "CreateBlog":
				BlogOwner ownerBlog = new BlogOwner();
				Blog blog = new Blog();
				blog.setTitle(request.getParameter("title"));
				blog.setCategorie(request.getParameter("categorie"));
				ownerBlog.setId( Integer.parseInt(request.getParameter("idOwnerBlog")));
				blogdao.createBlog(blog, ownerBlog );
				this.rd = request.getRequestDispatcher("ServletBlogOwner?action="
									 +"ListOwner&idOwnerBlog.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to show all your blogs
			case "ListBlog":
				List<Blog> listBlog = new ArrayList<>();
				listBlog = blogdao.listBlog();
				request.setAttribute("listBlog", listBlog);
				this.rd = request.getRequestDispatcher("listBlogs.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to allow the user delete their blog
			case "DeleteBlog":
				String idBlog = request.getParameter("idBlog");
				blogdao.deleteBlog(idBlog);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to show the all your publications
			case "ListPublications":
				List<Publication> listPublication = new ArrayList<>();
				String idBlogPublication =  request.getParameter("idBlog") ;
				listPublication = blogdao.listPublicationBlog(idBlogPublication);
				request.setAttribute("listaPublicacaoBlog", listPublication);
				this.rd = request.getRequestDispatcher("listPublication.jsp");
				this.rd.forward(request, response);
				break;

			// this case is used to show the all publications about your blog
			case "ListPublicationsBlog":
				List<Publication> listPublicationBlog = new ArrayList<>();
				idBlogPublication =  request.getParameter("idBlog") ;
				listPublicationBlog = blogdao.listPublicationBlog(idBlogPublication);
				request.setAttribute("listaPublicacaoBlog", listPublicationBlog);
				this.rd = request.getRequestDispatcher("listPublicationsBlog.jsp");
				this.rd.forward(request, response);
				break;

			// Instantiates only one publication
			case "InstancePublication":
				String idBlogInstance = request.getParameter("idBlog");
				request.setAttribute("idBlog", idBlogInstance);
				this.rd = request.getRequestDispatcher("painelAdministrativoBlog.jsp");
				this.rd.forward(request, response);
				break;

			default:
				// nothing to do
				break;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
