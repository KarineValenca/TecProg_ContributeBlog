package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class AuthenticationDAO extends ConnectionFactory{
	User utilizador = new User();
	
	
	public User authenticateUser(String email, String password){
		assert(email != null ) : "Unexpected error: the email is receiving null";
		assert(password != null) : "Unexpected error: the password is receiving null";
		
		this.utilizador.setEmail("");
		this.utilizador.setPassword("");
		
		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where email='"+ email+"' and senha='"+password+"'" );
			while(rs.next()){
			
				this.utilizador.setId(rs.getInt("id"));
				this.utilizador.setName(rs.getString("nome"));
				this.utilizador.setLastName(rs.getString("sobrenome"));
				this.utilizador.setGender(rs.getString("genero"));
				this.utilizador.setNickname(rs.getString("apelido"));
				this.utilizador.setEmail(rs.getString("email"));
				this.utilizador.setPassword(rs.getString("senha"));
				this.utilizador.setBirthDate(rs.getDate("dataNascimento"));
			}
			rs.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return this.utilizador;
	}
}
