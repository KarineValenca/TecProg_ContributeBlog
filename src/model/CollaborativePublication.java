package model;

public class PublicacaoColaborativa extends Publication {


	boolean statusPublication;
	User utilizador;


	public PublicacaoColaborativa() {
		// TODO Auto-generated constructor stub
	}


	public PublicacaoColaborativa(int idPublication, String titlePublication,
			String categoryPublication, String contentPublication, Blog idBlog,
			int gradePublication) {
		super(idPublication, titlePublication, categoryPublication, contentPublication,
				idBlog, gradePublication);
		// TODO Auto-generated constructor stub
	}





}
