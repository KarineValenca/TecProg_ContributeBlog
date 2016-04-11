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



@WebServlet("/ServletBlogOwner")
public class ServletBlogOwner extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
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
