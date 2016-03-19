package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Denuncia;
import model.DenunciaPublicacao;


public class DenunciaPublicacaoDAO extends ConnectionFactory implements DenunciaDAO{
	public List<Denuncia> listarDenuncia() {
		List<Denuncia> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Denuncia where idPublicacao IS NOT NULL");
			
			while (rs.next()) {
				Denuncia denunciaPublicacao = new DenunciaPublicacao();
				denunciaPublicacao.setIdDenuncia(rs.getInt("idDenuncia"));
				denunciaPublicacao.setConteudoDenuncia(rs.getString("conteudoDenuncia"));
				lista.add(denunciaPublicacao);
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
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from Denuncia where idDenuncia ="+idDenuncia);
		
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
