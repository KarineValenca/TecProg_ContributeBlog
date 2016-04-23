/*
 * Class name: ServletBlogOwner
 * Purpose of class: This class is responsible for, using the RequestDispatcher
 * objetc, acess the blogs list views pages, according to the requested action.
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

import dao.BlogOwnerDAO;
import model.Blog;
import model.BlogOwner;

public class ServletBlogOwner extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	/*this method is used to intercept HTTP GET requests. The HTTP GET 
	 requests are used when you get the same result everytime you execute the 
	 request*/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
		
		doPost(request, response);
	}
	
	/*this method is used to intercept HTTP POST requests. The HTTP POST 
	  request are used when the results of the requests will not be the same*/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		assert (request != null) : "The request from user is null";
		assert (response != null) : "The response to user is null";
	
		List<Blog> listBlog = new ArrayList<>();
		
		String action = request.getParameter("action");
		BlogOwnerDAO blogOwnerDAO = new BlogOwnerDAO();
		switch (action) {
		
		case "ListOwner":
			System.out.println("Listarblogservlet");
			String idBlogOwner =  request.getParameter("idBlogOwner") ;				
			listBlog = blogOwnerDAO.listBlogOwner(idBlogOwner);
			request.setAttribute("listBlogOwner", listBlog);
			this.rd = request.getRequestDispatcher("listBlogsOwners.jsp");
			this.rd.forward(request, response);
		
		break;
		
			default:
			break;
		}
		
	}

}
