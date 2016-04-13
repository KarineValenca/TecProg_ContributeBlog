package model;

public class Publication {
	private int idPublication;
	private String titlePublication;
	private String categoryPublication;
	private String contentPublication;
	private Blog idBlog;
	private int nota;
	private boolean statusPublicacao;
	private User utilizador;

	public Publication(){

	}

	public Publication(int idPublication, String titlePublication, String categoryPublication,
			String contentPublication, Blog idBlog, int nota){
		this.idPublication = idPublication;
		this.titlePublication = titlePublication;
		this.categoryPublication = categoryPublication;
		this.contentPublication = contentPublication;
		this.idBlog = idBlog;
		this.nota = nota;

	}

	public int getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}
	public String getTitlePublication() {
		return titlePublication;
	}
	public void setTitlePublication(String titlePublication) {
		this.titlePublication = titlePublication;
	}
	public String getCategoryPublication() {
		return categoryPublication;
	}
	public void setCategoryPublication(String categoryPublication) {
		this.categoryPublication = categoryPublication;
	}
	public String getContentPublication() {
		return contentPublication;
	}
	public void setContentPublication(String contentPublication) {
		this.contentPublication = contentPublication;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
