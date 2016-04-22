/*
 * Class name: AuthenticationDAO.java
 * Purpose of class: This class is used to allow a user login at system
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.User;

public class AuthenticationDAO extends ConnectionFactory{
	User user = new User();
	
	// this method allows the user login in system
	public User authenticateUser(String email, String password){
		assert(email != null ) : "Unexpected error: the email is receiving null";
		assert(password != null) : "Unexpected error: the password is receiving"
									+ " null";
		this.user.setEmail("");
		this.user.setPassword("");
		
		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			String sql = "select * from Utilizador where email='"+ email+"' "
							+ "and senha='"+password+"'";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				this.user.setId(rs.getInt("id"));
				this.user.setName(rs.getString("nome"));
				this.user.setLastName(rs.getString("sobrenome"));
				this.user.setGender(rs.getString("genero"));
				this.user.setNickname(rs.getString("apelido"));
				this.user.setEmail(rs.getString("email"));
				this.user.setPassword(rs.getString("senha"));
				this.user.setBirthDate(rs.getDate("dataNascimento"));
			}
			
			rs.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
		return this.user;
	}
}
