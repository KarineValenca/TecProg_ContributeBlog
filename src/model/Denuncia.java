package model;

import java.util.Date;

public class Denuncia {
	private int idDenuncia;
	private Date dataDenuncia;
	private String conteudoDenuncia;
	private int idBlog; 
	
	public Denuncia(){
		
	}
	
	public Denuncia(int idDenuncia, Date dataDenuncia, String conteudoDenuncia, int idBlog){
		this.idDenuncia = idDenuncia;
		this.dataDenuncia = dataDenuncia;
		this.conteudoDenuncia = conteudoDenuncia;
		this.idBlog = idBlog;
		
	}
	
	public int getIdDenuncia() {
		return idDenuncia;
	}
	public int getIdBlog() {
		return idBlog;
	}

	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}

	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public Date getDataDenuncia() {
		return dataDenuncia;
	}
	public void setDataDenuncia(Date dataDenuncia) {
		this.dataDenuncia = dataDenuncia;
	}
	public String getConteudoDenuncia() {
		return conteudoDenuncia;
	}
	public void setConteudoDenuncia(String conteudoDenuncia) {
		this.conteudoDenuncia = conteudoDenuncia;
	}
	
}
