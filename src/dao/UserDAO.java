package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.User;


public class UserDAO  extends ConnectionFactory{
	
	User user = new User();
	
	public int validateUser(String nickname, String email, int value){
		assert(nickname != null) : "unexpected error: the nickname is recieving null";
		assert(email != null) : "unexpected error: the email is recieving null";
		
		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select count(*) as rowcount from Utilizador "
					+ "where apelido='"+nickname+"' or email='"+email+"'");
			rs.next();
			value = rs.getInt("rowcount");
			
			rs.close();
			connection.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	public void createUser(User user) {
		assert(user != null) : "Unexpected error: the object User is null";
		
		try {
			java.util.Date utilDate = user.getBirthDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			Connection connection = getConnection();
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO Utilizador (nome,sobrenome,email,genero,senha,apelido, dataNascimento) VALUES(?,?,?,?,?,?,?);");
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getLastName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getPassword());
			pstm.setString(6, user.getNickname());
			pstm.setDate(7, sqlDate);
			pstm.execute();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> listUser() {
		List<User> usersList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Utilizador");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("nome"));
				user.setLastName(rs.getString("sobrenome"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("senha"));
				user.setNickname(rs.getString("apelido"));
				user.setBirthDate(rs.getDate("dataNascimento"));
				
				
				usersList.add(user);
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
		
	public void deleteUser(String id) {
		// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		try {
			Connection connection = getConnection();
			PreparedStatement pstm = connection
					.prepareStatement("Delete from Utilizador where id ="+id);
		
			pstm.execute();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editUser(User user, String id){
		// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(user != null) : "Unexpected error: The object user is null";
		
		try{
			java.util.Date utilDate = user.getBirthDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("update Utilizador set nome=?, sobrenome=?, genero=?, senha=?, apelido=?, dataNascimento=? where id=?");
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getLastName());
			pstm.setString(3, user.getGender());
			pstm.setString(4, user.getPassword());
			pstm.setString(5, user.getNickname());
			pstm.setDate(6, sqlDate);
			
			pstm.setString(7, id);
			pstm.execute();
			pstm.close();
			connection.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public User showUserProfile(String id) {
		// FIX-ME: THERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		User user = new User();
		user.setName("");
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Utilizador where id="+id);
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("nome"));
				user.setLastName(rs.getString("sobrenome"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("genero"));
				user.setPassword(rs.getString("senha"));
				user.setNickname(rs.getString("apelido"));
				user.setBirthDate(rs.getDate("dataNascimento"));
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
