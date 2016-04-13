package model;

public class Publication {
	private int idPublication;
	private String titlePublication;
	private String categoriaPublicacao;
	private String conteudoPublicacao;
	private Blog idBlog;
	private int nota;
	private boolean statusPublicacao;
	private User utilizador;

	public Publication(){

	}

	public Publication(int idPublication, String titlePublication, String categoriaPublicacao,
			String conteudoPublicacao, Blog idBlog, int nota){
		this.idPublication = idPublication;
		this.titlePublication = titlePublication;
		this.categoriaPublicacao = categoriaPublicacao;
		this.conteudoPublicacao = conteudoPublicacao;
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
	public String getCategoriaPublicacao() {
		return categoriaPublicacao;
	}
	public void setCategoriaPublicacao(String categoriaPublicacao) {
		this.categoriaPublicacao = categoriaPublicacao;
	}
	public String getConteudoPublicacao() {
		return conteudoPublicacao;
	}
	public void setConteudoPublicacao(String conteudoPublicacao) {
		this.conteudoPublicacao = conteudoPublicacao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
