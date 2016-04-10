package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Denounce;
import model.DenounceBlog;

public class DenounceBlogDAO extends ConnectionFactory implements DenounceDAO{
	public List<Denounce> listDenounce() {
		List<Denounce> list = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Denuncia where idPublicacao IS NULL");
			
			while (rs.next()) {
				Denounce denounceBlog = new DenounceBlog();
				denounceBlog.setIdDenounce(rs.getInt("idDenounce"));
				denounceBlog.setContentDenounce(rs.getString("contentDenounce"));
				//blog.setDataCriacao(rs.getDate("dataCriacao"));
				list.add(denounceBlog);
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteDenounce(String idDenounce) {
		try {
			Connection connection = getConnection();
			PreparedStatement pstm = connection
					.prepareStatement("Delete from Denuncia where idDenuncia ="+idDenounce);
		
			pstm.execute();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Denounce pesquisaBlogDenuncia(String idDenuncia) {
	
		Denounce denounceBlog = new Denounce();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Denuncia where idDenuncia ="+idDenounce);
			
			while (rs.next()) {
				
				denounceBlog.setIdDenounce(rs.getInt("idDenounce"));
				denounceBlog.setContentDenounce(rs.getString("contentDenunce"));
				denounceBlog.setIdBlog( rs.getInt("idBlog"));
			}
			
			
			
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return denounceBlog;
	}

}
