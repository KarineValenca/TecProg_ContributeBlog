/**
 * File name: ServletBlogOwner.java
 * Purpose of file: This file is composed by a ServletBlogOwner class and 
 * methods.
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

/**
 * Class name: ServletBlogOwner
 * Purpose of class: This class is responsible for, using the RequestDispatcher
 * objetc, acess the blogs list views pages, according to the requested action.
 */
public class ServletBlogOwner extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	/**
	 * Method name: doGet
	 * Purpose of method: This method is used to intercept HTTP GET requests.
	 * The HTTP GET requests are used when you get the same result everytime 
	 * you execute the request.
	 * @param request Represent the HTTP request that a browser sends to the 
	 * application.
	 * @param response Represent the HTTP response that the application sends 
	 * to a browser.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//assert (request != null) : "The request from user is null";
		//assert (response != null) : "The response to user is null";
		System.out.println("Aqui+++++++++++++");
		
		doPost(request, response);
	}
	
	/**
	 * Method name: doPost
	 * Purpose of method: This method is used to intercept HTTP POST requests. 
	 * The HTTP POST request are used when the results of the requests will not
	 * be the same.
	 * @param request Represent the HTTP request that a browser sends to the 
	 * application.
	 * @param response Represent the HTTP response that the application sends 
	 * to a browser. 
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//assert (request != null) : "The request from user is null";
		//assert (response != null) : "The response to user is null";
	
		String action = request.getParameter("action");
		
		switch (action) {
		
			case "ListOwner":
				String idBlogOwner =  request.getParameter("idBlogOwner") ;	
				List<Blog> listBlog = new ArrayList<>();
				BlogOwnerDAO blogOwnerDAO = new BlogOwnerDAO();
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
