package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Denuncia;
import model.DenunciaBlog;
import model.User;

public interface FabricaDenunciaDAO {
	//Denuncia denuncia;
	
	void criarDenuncia(int id, Denuncia denuncia, User utilizador);
	
	
	
}
