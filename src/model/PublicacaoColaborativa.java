package model;

public class PublicacaoColaborativa extends Publication {


	boolean statusPublicacao;
	User utilizador;


	public PublicacaoColaborativa() {
		// TODO Auto-generated constructor stub
	}


	public PublicacaoColaborativa(int idPublication, String titlePublication,
			String categoryPublication, String contentPublication, Blog idBlog,
			int nota) {
		super(idPublication, titlePublication, categoryPublication, contentPublication,
				idBlog, nota);
		// TODO Auto-generated constructor stub
	}





}
