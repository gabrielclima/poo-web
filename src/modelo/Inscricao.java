package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "inscricoes", 
    uniqueConstraints=@UniqueConstraint(columnNames={"cpf","fk_concurso_id"}))
public class Inscricao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_INSCRICAO")
	@SequenceGenerator(name = "ID_INSCRICAO", sequenceName = "SEQ_ID_INSCRICAO",
	                    allocationSize = 1, initialValue=10000)
	private Integer numeroInscricao;

	@Column(length=120, nullable=false)
	private String nome = "";
	
	@Column(length=11, nullable=false)
	private String cpf = "";
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_concurso_id", nullable=false)
	private Concurso concurso;

	public Integer getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Integer numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public String getNascimentoFormatado() {
		if (this.nascimento == null)
			return "";

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		return formatador.format(this.nascimento);
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroInscricao == null) ? 0 : numeroInscricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscricao other = (Inscricao) obj;
		if (numeroInscricao == null) {
			if (other.numeroInscricao != null)
				return false;
		} else if (!numeroInscricao.equals(other.numeroInscricao))
			return false;
		return true;
	}
	
	

}
