/** 
 * File name: ServletDenounce.java
 * Purpose of file: this file contains the ServletDenounce class and its methods.   
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

/**
 * Class name: ServletDenounce
 * Purpose of class: This class keeps denounces. It has some specific tasks such
 * as denounce a publication, denounce a blog and delete a denounce of 
 * publication or blog.
 */
@WebServlet("/ServletDenounce")
public class ServletDenounce extends HttpServlet{
	private static final long serialVersionUID = 1L;
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
     */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) 
						 throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
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
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) 
						  throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		String action = request.getParameter("action");
		DenounceBlog denounceBlog = new DenounceBlog();
		DenouncePublication denouncePublication = new DenouncePublication();
		FactoryDenounceBlogDAO factoryDenounceBlogDAO = new 
				FactoryDenounceBlogDAO();
		DenounceBlogDAO denounceBlogDAO = new DenounceBlogDAO();
		FactoryDenouncePublicationDAO factoryDenouncePublicationDAO = new 
				FactoryDenouncePublicationDAO();
		DenouncePublicationDAO denouncePublicationDAO = new 
				DenouncePublicationDAO();
		User user = new User();
		Blog blog = new Blog();
		List<Denounce> listDenounceBlog = new ArrayList<>();
		List<Denounce> listDenouncePublication = new ArrayList<>();

		try {
			switch (action) {
				//implementation of create blog denounce
				case "CreateDenounceBlog":
					denounceBlog.setContentDenounce(request.getParameter("content"
																+ "Denounce"));
					System.out.println(request.getParameter("contentDenounce"));
					user.setId(Integer.parseInt(request.getParameter("id")));
					int idBlog = Integer.parseInt(request.getParameter("idBlog"));
					factoryDenounceBlogDAO.createDenounce(idBlog, denounceBlog, 
													  	  user);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of blog instance
				case "InstanceBlog":
					String idBlogD= request.getParameter("idBlog");
					request.setAttribute("idBlog", idBlogD);
					this.rd = request.getRequestDispatcher("denounceBlog.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of create publication denounce
				case "CreateDenouncePublication":
					denouncePublication.setContentDenounce(request.getParameter(""
						+ "contentDenounce"));
					System.out.println(denouncePublication.getContentDenounce());
					user.setId(Integer.parseInt(request.getParameter("id")));
					int idPublication = Integer.parseInt(request.getParameter("id"
						+ "Publication"));
					factoryDenouncePublicationDAO.createDenounce(idPublication, 
						denouncePublication, user);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation publication instance
				case "InstancePublication":
					String idPublicationD= request.getParameter("idPublication");
					request.setAttribute("idPublication", idPublicationD);
					this.rd = request.getRequestDispatcher("denounce"
						+ "Publication.jsp");
					this.rd.forward(request, response);
					break;
				
				//implementation of list denounces
				case "ListDenounce":
					listDenounceBlog = denounceBlogDAO.listDenounce();
					request.setAttribute("listDenounceBlog", listDenounceBlog);
					listDenouncePublication = denouncePublicationDAO.listDenounce();
					request.setAttribute("listDenouncePublication", 
									  	  listDenouncePublication);
					this.rd = request.getRequestDispatcher("listDenounce.jsp");
					this.rd.forward(request, response);
				
				//implementation of delete blog denounce
				case "DeleteDenounceBlog":
					String idDenounce = request.getParameter("idDenounce");
					denounceBlogDAO.deleteDenounce(idDenounce);
					this.rd.forward(request, response);
					break;
				
				//implementation of delete publication denounce
				case "DeleteDenouncePublication":
					idDenounce = request.getParameter("idDenounce");
					denouncePublicationDAO.deleteDenounce(idDenounce);
					this.rd = request.getRequestDispatcher("ServletDenounce?action="
						+ "ListDenounce");
					this.rd.forward(request, response);
					break;
				
				//implementation of delete blog of denounce
				case "DeleteBlogDenounce":
					System.out.println("Delete");
					idDenounce = request.getParameter("idDenounce");
					System.out.println(idDenounce);
					DenounceBlogDAO denounceDAO = new DenounceBlogDAO();
					BlogDAO blogDao = new BlogDAO();
					Denounce denounce = denounceDAO.searchBlogDenounce(idDenounce);
					System.out.println(denounce.getContentDenounce());
					System.out.println("Aint"+denounce.getIdBlog());
					blogDao.deleteBlog( String.valueOf(denounce.getIdBlog()));
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
					break;
				
				default:
					// nothing to do
					break;
			}
		}
		catch(Exception e){
			// TODO: handle exception)
		}
	}
}

