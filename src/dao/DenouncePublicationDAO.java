package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Denounce;
import model.DenouncePublication;


public class DenouncePublicationDAO extends ConnectionFactory implements DenounceDAO{
	public List<Denounce> listDenounce() {
		List<Denounce> list = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Denuncia where idPublicacao IS NOT NULL");
			
			while (rs.next()) {
				Denounce denouncePublication = new DenouncePublication();
				denouncePublication.setIdDenounce(rs.getInt("idDenounce"));
				denouncePublication.setContentDenounce(rs.getString("contentDenounce"));
				list.add(denouncePublication);
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteDenounce(String idDenounce) {
		assert(idDenounce != null ) : "Unexpected error: the denounce identifier is receiving null";
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

}
