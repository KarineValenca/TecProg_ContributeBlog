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
		try {
			java.util.Date utilDate = user.getDataNascimento();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			Connection connection = getConnection();
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO Utilizador (nome,sobrenome,email,genero,senha,apelido, dataNascimento) VALUES(?,?,?,?,?,?,?);");
			pstm.setString(1, user.getNome());
			pstm.setString(2, user.getSobrenome());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getGenero());
			pstm.setString(5, user.getSenha());
			pstm.setString(6, user.getApelido());
			pstm.setDate(7, sqlDate);
			pstm.execute();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> listUser() {
		List<User> userList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Utilizador");
			while (rs.next()) {
				User utilizador = new User();
				utilizador.setId(rs.getInt("id"));
				utilizador.setNome(rs.getString("nome"));
				utilizador.setEmail(rs.getString("email"));
				utilizador.setSenha(rs.getString("senha"));
				utilizador.setApelido(rs.getString("apelido"));
				utilizador.setDataNascimento(rs.getDate("dataNascimento"));
				userList.add(utilizador);
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
		
	public void deleteUser(String id) {
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
		try{
			java.util.Date utilDate = user.getDataNascimento();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("update Utilizador set nome=?, sobrenome=?, genero=?, senha=?, apelido=?, dataNascimento=? where id=?");
			pstm.setString(1, user.getNome());
			pstm.setString(2, user.getSobrenome());
			pstm.setString(3, user.getGenero());
			pstm.setString(4, user.getSenha());
			pstm.setString(5, user.getApelido());
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
		User user = new User();
		user.setNome("");
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Utilizador where id="+id);
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setSobrenome(rs.getString("sobrenome"));
				user.setEmail(rs.getString("email"));
				user.setGenero(rs.getString("genero"));
				user.setSenha(rs.getString("senha"));
				user.setApelido(rs.getString("apelido"));
				user.setDataNascimento(rs.getDate("dataNascimento"));
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
