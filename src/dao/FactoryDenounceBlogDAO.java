package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import model.Denounce;
import model.DenounceBlog;
import model.DenouncePublication;
import model.User;

public class FactoryDenounceBlogDAO extends ConnectionFactory implements FactoryDenounceDAO {
	
	Date now = new Date();
	java.sql.Date sqlDate = new java.sql.Date(now.getTime());
	
	public void createDenounce(int idBlog, Denounce denounce, User user){
		assert(idBlog >= 0 ) : "Unexpected error: the blog identifier is receiving null";
		assert (denounce != null) : "unexpected error: the denounce object is null";
		assert (user != null) : "unexpected error: the user object is null";
		try{			
			Connection connection = getConnection();
			PreparedStatement pstm = connection.
					prepareStatement("INSERT INTO Denuncia (dataDenuncia, conteudoDenuncia, idBlog, idUtilizador) VALUES (?,?,?,?)");
			pstm.setDate(1, sqlDate);
			pstm.setString(2, denounce.getContentDenounce());
			pstm.setInt(3, idBlog);
			pstm.setInt(4, user.getId());
			pstm.execute();
			pstm.close();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
