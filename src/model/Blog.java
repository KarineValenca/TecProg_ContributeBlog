package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Blog {

	
	private int idBlog;
	private String title;
	private String categorie;
	private Date creationDate;
	private BlogOwner idDonoBlog;
	private List<Publication> publicacoes;
	
	
	public Blog() {
	}


	public int getIdBlog() {
		return idBlog;
	}


	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public BlogOwner getIdDonoBlog() {
		return idDonoBlog;
	}


	public void setIdDonoBlog(BlogOwner idDonoBlog) {
		this.idDonoBlog = idDonoBlog;
	}


	public List<Publication> getPublicacoes() {
		return publicacoes;
	}


	public void setPublicacoes(List<Publication> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
}

