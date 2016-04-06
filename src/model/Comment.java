package model;

import java.util.Date;

public class Comment {
	private int idComentario;
	private String conteudoComentario;
	private Date dataComentario;
	private String utilizadorComentario;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getConteudoComentario() {
		return conteudoComentario;
	}
	public void setCommentContent(String conteudoComentario) {
		this.conteudoComentario = conteudoComentario;
	}
	public Date getDataComentario() {
		return dataComentario;
	}
	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}
	public String getUtilizadorComentario() {
		return utilizadorComentario;
	}
	public void setUtilizadorComentario(String utilizadorComentario) {
		this.utilizadorComentario = utilizadorComentario;
	}
	
	
}
