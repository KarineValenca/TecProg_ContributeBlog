package dao;

import java.util.List;

import model.Denuncia;

public interface DenunciaDAO {
	public List<Denuncia> listarDenuncia ();
	public void excluirDenuncia(String idDenuncia);
}
