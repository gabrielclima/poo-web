package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concursos")
public class Concurso {

	@Id
	private Integer codigoConcurso;

	private String descricao;

	@OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY)
	private List<Inscricao> inscricoes;

	public Concurso() {
		super();
	}

	public Concurso(Integer codigoConcurso, String descricao) {
		super();
		this.codigoConcurso = codigoConcurso;
		this.descricao = descricao;
	}

	public Integer getCodigoConcurso() {
		return codigoConcurso;
	}

	public void setCodigoConcurso(Integer codigoConcurso) {
		this.codigoConcurso = codigoConcurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoConcurso == null) ? 0 : codigoConcurso.hashCode());
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
		Concurso other = (Concurso) obj;
		if (codigoConcurso == null) {
			if (other.codigoConcurso != null)
				return false;
		} else if (!codigoConcurso.equals(other.codigoConcurso))
			return false;
		return true;
	}

	
	
	
	
}
