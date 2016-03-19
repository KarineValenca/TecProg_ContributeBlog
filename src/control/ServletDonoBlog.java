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

import dao.DonoBlogDAO;
import model.Blog;
import model.DonoBlog;



@WebServlet("/ServletDonoBlog")
public class ServletDonoBlog extends HttpServlet {

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
	
		List<Blog> lista = new ArrayList<>();
		
		
		
		String acao = request.getParameter("acao");
		DonoBlogDAO donoBlogDAO = new DonoBlogDAO();
		switch (acao) {
		
		case "ListarDono":
			
			String idDonoBlog =  request.getParameter("idDonoBlog") ;				
			lista = donoBlogDAO.listarBlogDono(idDonoBlog);
			request.setAttribute("listaBlogDono", lista);
			this.rd = request.getRequestDispatcher("listarBlogsDono.jsp");
			this.rd.forward(request, response);
		
		break;
	
		

		default:
			break;
		}
		
		
		
		
		
	}

}
