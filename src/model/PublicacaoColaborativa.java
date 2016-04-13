package model;

public class PublicacaoColaborativa extends Publication {


	boolean statusPublicacao;
	User utilizador;


	public PublicacaoColaborativa() {
		// TODO Auto-generated constructor stub
	}


	public PublicacaoColaborativa(int idPublication, String titlePublication,
			String categoryPublication, String conteudoPublicacao, Blog idBlog,
			int nota) {
		super(idPublication, titlePublication, categoryPublication, conteudoPublicacao,
				idBlog, nota);
		// TODO Auto-generated constructor stub
	}





}
