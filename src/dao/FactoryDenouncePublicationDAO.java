package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Denounce;
import model.DenounceBlog;
import model.DenouncePublication;
import model.User;

public class FactoryDenouncePublicationDAO extends ConnectionFactory implements FactoryDenounceDAO {
	Date now = new Date();
	java.sql.Date sqlDate = new java.sql.Date(now.getTime());
	public void createDenounce(int id, Denounce denounce, User user){
		try{

			Connection connection = getConnection();
			PreparedStatement pstm = connection.
					prepareStatement("INSERT INTO Denuncia (dataDenuncia, conteudoDenuncia, idPublicacao, idUtilizador) VALUES (?,?,?,?)");
			pstm.setDate(1, sqlDate);
			pstm.setString(2, denounce.getContentDenounce());
			pstm.setInt(3, id);
			pstm.setInt(4, user.getId());
			pstm.execute();
			pstm.close();
			connection.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}


}
