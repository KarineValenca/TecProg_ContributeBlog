/**
 * File name: AuthenticacionDAO.java 
 * Purpose of file: This file contains the AuthenticationDAO class and its
 * methods.
 * Copyright: This software follows GPL license. 
 **/

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.User;

/**
 * Class name: AuthenticationDAO
 * Purpose of class: This class is used to allow a user login at system doing
 * connection with database.
 **/
public class AuthenticationDAO extends ConnectionFactory{
	/**
	 * Method name: authenticateUser
	 * Purpose of method: This method allows the user login at the system. 
	 * @param email: used to check with the email is registered and if it 
	 * matches with the password.
	 * @param password: used to check with the password matches with the email.
	 * @return: it returns a User object 
	 **/
	public User authenticateUser(String email, String password){
		assert(email != null ) : "Unexpected error: the email is receiving null";
		assert(password != null) : "Unexpected error: the password is receiving"
									+ " null";
		
		User user = new User();
		
		// this user.setEmail will change if the email and password are correct
		user.setEmail("Not authorized");
		user.setPassword("Not authorized");
		
		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			String sql = "select * from Utilizador where email='"+ email+"' "
							+ "and senha='"+password+"'";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("nome"));
				user.setLastName(rs.getString("sobrenome"));
				user.setGender(rs.getString("genero"));
				user.setNickname(rs.getString("apelido"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("senha"));
				user.setBirthDate(rs.getDate("dataNascimento"));
			}
			
			rs.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
		return user;
	}
}
