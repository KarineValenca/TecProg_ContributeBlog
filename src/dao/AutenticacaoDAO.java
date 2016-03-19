package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Utilizador;

public class AutenticacaoDAO extends ConnectionFactory{
	Utilizador utilizador = new Utilizador();
	
	
	public Utilizador autenticarUtilizador(String email, String senha){
		this.utilizador.setEmail("");
		this.utilizador.setSenha("");
		
		try{
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where email='"+ email+"' and senha='"+senha+"'" );
			while(rs.next()){
			
				this.utilizador.setId(rs.getInt("id"));
				this.utilizador.setNome(rs.getString("nome"));
				this.utilizador.setSobrenome(rs.getString("sobrenome"));
				this.utilizador.setGenero(rs.getString("genero"));
				this.utilizador.setApelido(rs.getString("apelido"));
				this.utilizador.setEmail(rs.getString("email"));
				this.utilizador.setSenha(rs.getString("senha"));
				this.utilizador.setDataNascimento(rs.getDate("dataNascimento"));
			}
			rs.close();
			conexao.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return this.utilizador;
	}
}
