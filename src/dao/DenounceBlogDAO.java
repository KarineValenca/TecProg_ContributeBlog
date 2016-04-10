package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Denuncia;
import model.DenunciaBlog;

public class DenunciaBlogDAO extends ConnectionFactory implements DenunciaDAO{
	public List<Denuncia> listarDenuncia() {
		List<Denuncia> lista = new ArrayList<>();
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Denuncia where idPublicacao IS NULL");
			
			while (rs.next()) {
				Denuncia denunciaBlog = new DenunciaBlog();
				denunciaBlog.setIdDenuncia(rs.getInt("idDenuncia"));
				denunciaBlog.setConteudoDenuncia(rs.getString("conteudoDenuncia"));
				//blog.setDataCriacao(rs.getDate("dataCriacao"));
				lista.add(denunciaBlog);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluirDenuncia(String idDenuncia) {
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from Denuncia where idDenuncia ="+idDenuncia);
		
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Denuncia pesquisaBlogDenuncia(String idDenuncia) {
	
		Denuncia denunciaBlog = new Denuncia();
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Denuncia where idDenuncia ="+idDenuncia);
			
			while (rs.next()) {
				
				denunciaBlog.setIdDenuncia(rs.getInt("idDenuncia"));
				denunciaBlog.setConteudoDenuncia(rs.getString("conteudoDenuncia"));
				denunciaBlog.setIdBlog( rs.getInt("idBlog"));
			}
			
			
			
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return denunciaBlog;
	}

}
