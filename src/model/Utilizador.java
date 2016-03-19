package model;
import java.util.Date;

public class Utilizador {

	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String genero;
	private String senha;
	private String apelido;
	private Date dataNascimento;
	
	
	public Utilizador() {
	}


	public Utilizador(int id, String nome, String sobrenome, String email,
			String genero, String senha, String apelido, Date dataNascimento) {

		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.genero = genero;
		this.senha = senha;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getApelido() {
		return apelido;
	}



	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
