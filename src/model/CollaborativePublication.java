package model;

public class CollaborativePublication extends Publication {


	boolean statusPublication;
	User utilizador;


	public CollaborativePublication() {
		// TODO Auto-generated constructor stub
	}


	public CollaborativePublication(int idPublication, String titlePublication,
			String categoryPublication, String contentPublication, Blog idBlog,
			int gradePublication) {
		super(idPublication, titlePublication, categoryPublication, contentPublication,
				idBlog, gradePublication);
		// TODO Auto-generated constructor stub
	}





}
