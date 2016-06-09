package modelo.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_usuario")
	@SequenceGenerator(name = "id_usuario", sequenceName = "SEQ_ID_usuario",
	                    allocationSize = 1, initialValue=1)
	private int id;
	
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private boolean admin;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, String nome, String cpf, Date dataNascimento, boolean admin) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.admin = admin;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", admin=" + admin + "]";
	}

	public boolean verificaSenha(String senhaDigitada) {
		if (senhaDigitada.equals("123")) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}








