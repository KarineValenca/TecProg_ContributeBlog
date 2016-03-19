package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Blog {

	
	private int idBlog;
	private String titulo;
	private String categoria;
	private Date dataCriacao;
	private DonoBlog idDonoBlog;
	private List<Publicacao> publicacoes;
	
	
	public Blog() {
	}



	public Blog(int idBlog, String titulo, String categoria, Date dataCriacao, DonoBlog idDonoBlog, 
			ArrayList<Publicacao> publicacoes) {

		this.idBlog = idBlog;
		this.titulo = titulo;
		this.categoria = categoria;
		this.dataCriacao = dataCriacao;
		this.idDonoBlog = idDonoBlog;
		this.publicacoes = publicacoes;
	}


	public int getIdBlog() {
		return idBlog;
	}



	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Date getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}



	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}



	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
}
