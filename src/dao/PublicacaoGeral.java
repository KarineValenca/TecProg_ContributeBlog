package dao;

import model.Publication;

public interface PublicacaoGeral {
	
	public void publicar(int idBlog, Publication publicacao);
	public Publication listar(String idPublicacao);

}
