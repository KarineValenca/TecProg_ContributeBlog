package model;

public class PublicacaoColaborativa extends Publicacao {

	
	boolean statusPublicacao;
	Utilizador utilizador;
	
	
	public PublicacaoColaborativa() {
		// TODO Auto-generated constructor stub
	}


	public PublicacaoColaborativa(int idPublicacao, String tituloPublicacao,
			String categoriaPublicacao, String conteudoPublicacao, Blog idBlog,
			int nota) {
		super(idPublicacao, tituloPublicacao, categoriaPublicacao, conteudoPublicacao,
				idBlog, nota);
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
