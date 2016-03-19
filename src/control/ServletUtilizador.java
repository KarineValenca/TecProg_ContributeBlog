package control;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilizadorDAO;
import model.Utilizador;


@WebServlet("/ServletUtilizador")
public class ServletUtilizador extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String acao = request.getParameter("acao");
		String destino = "sucesso.jsp";
		String mensagem = "";
		List<Utilizador> lista = new ArrayList<>();
		UtilizadorDAO utilizadordao = new UtilizadorDAO();
		Utilizador utilizador = new Utilizador();
		
		String dataNascimento = request.getParameter("dataNascimento");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			switch (acao) {
				
			case "Listar":
				lista = utilizadordao.listarUtilizador();
				request.setAttribute("listaUtilizador", lista);
				this.rd = request.getRequestDispatcher("listarUtilizadores.jsp");
				this.rd.forward(request, response);
				break;
			case "Incluir":
				utilizador.setNome(request.getParameter("nome"));
				utilizador.setSobrenome(request.getParameter("sobrenome"));
				utilizador.setGenero(request.getParameter("genero"));
				utilizador.setEmail(request.getParameter("email"));
				utilizador.setSenha(request.getParameter("senha"));
				utilizador.setApelido(request.getParameter("apelido"));
				
				
				Date date = (Date) formatter.parse(dataNascimento);
				utilizador.setDataNascimento(date);				
			
				int retorno=0;

				
				retorno = utilizadordao.validarUtilizador(utilizador.getApelido(), utilizador.getEmail(), retorno);
				
				if(retorno==0){
					utilizadordao.criarUtilizador(utilizador);
					this.rd = request.getRequestDispatcher("index.jsp");
					this.rd.forward(request, response);
				}else{
					mensagem = "Email ou Apelido já utilizado";
					this.rd = request.getRequestDispatcher("utilizador.jsp");
					this.rd.forward(request, response);
				}
				
				break;
			case "Excluir":
				String id = request.getParameter("id");				
				utilizadordao.excluir(id);
				this.rd = request.getRequestDispatcher("index.jsp");
				this.rd.forward(request, response);
				
			break;
			case "Editar":
				id = request.getParameter("id");
				
				utilizador.setNome(request.getParameter("nome"));
				utilizador.setSobrenome(request.getParameter("sobrenome"));
				utilizador.setGenero(request.getParameter("genero"));
				utilizador.setSenha(request.getParameter("senha"));
				utilizador.setApelido(request.getParameter("apelido"));
				
				Date data = (Date) formatter.parse(dataNascimento);
				utilizador.setDataNascimento(data);
				
				utilizadordao.editarUtilizador(utilizador, id);
				this.rd = request.getRequestDispatcher("ServletAutenticacao");
				this.rd.forward(request, response);
				
				break;
			
			case "ListarPerfil":
				id = request.getParameter("id");
				utilizador = utilizadordao.listarPerfilUtilizador(id);
				request.setAttribute("utilizador", utilizador);
				this.rd = request.getRequestDispatcher("editarUtilizador.jsp");
				this.rd.forward(request, response);
				
			case "SubmeterPostagem":
				/*
				 * Pegar o Id do Blog e o id do usuário 
				 * e cria uma solicitação de postagem que vai ser aprovada pelo Dono do blog.
				 * Tabela Blog tem varias ou nenhuma postagem submetidas
				 * Criar tabela de postagens Submetidas com o indice do blog
				 * Criar função para Adicionar postatgemSubmetida ao blog
				 * Adicionar postagem submetida a postagem do BLog
				 * Lista todas as postagens do blog incluindo as submetidas
				 * 
				 * 
				 * */	
				
				
				
			default:
				break;
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}			
		
	
	
}
