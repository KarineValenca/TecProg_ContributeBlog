package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Utilizador;

public class AuthenticationDAO extends ConnectionFactory{
	Utilizador utilizador = new Utilizador();
	
	
	public Utilizador authenticateUser(String email, String password){
		this.utilizador.setEmail("");
		this.utilizador.setSenha("");
		
		try{
			Connection connection = getConexao();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where email='"+ email+"' and senha='"+password+"'" );
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
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return this.utilizador;
	}
}
