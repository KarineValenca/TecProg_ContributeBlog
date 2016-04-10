package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Denounce;
import model.DenounceBlog;
import model.User;

public interface FactoryDenounceDAO {
	//Denuncia denuncia;
	
	void createDenounce(int id, Denounce denounce, User user);
	
	
	
}
