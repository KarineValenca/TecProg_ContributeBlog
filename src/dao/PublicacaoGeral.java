package dao;

import model.Publicacao;

public interface PublicacaoGeral {
	
	public void publicar(int idBlog, Publicacao publicacao);
	public Publicacao listar(String idPublicacao);

}
