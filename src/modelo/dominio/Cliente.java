package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

public class Cliente extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Cliente() {
		super();
	}

	public Cliente(String login, String senha, String nome, String cpf, Date dataNascimento) {
		super(login, senha, nome, cpf, dataNascimento, false);
	}
}
