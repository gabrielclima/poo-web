package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locacoes")
public class Locacao {
	
	@Id
	private int registro;
	private Cliente cliente;
	private Filme filme;
	
	public Locacao(Cliente cliente, Filme filme) {
		super();
		this.cliente = cliente;
		this.filme = filme;
		this.registro = registro;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//	public ArrayList<Filme> getFilmes() {
//		return filmes;
//	}
//
//	public void setFilmes(ArrayList<Filme> filmes) {
//		this.filmes = filmes;
//	}

}
