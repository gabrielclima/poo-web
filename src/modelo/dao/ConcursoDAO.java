package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.Concurso;
import modelo.util.JpaDAO;

public class ConcursoDAO extends JpaDAO<Concurso> {

	public ConcursoDAO() {
		super();
	}

	public ConcursoDAO(EntityManager manager) {
		super(manager);
	}

	public List<Concurso> obterConcursos() {
		List<Concurso> retorno = super.lerTodos();

		// SE A TABELA ESTIVER VAZIA DEVE INCLUIR OS REGISTROS PADRÃO (APENAS
		// PARA TESTE)
		if (retorno == null || retorno.size() == 0) {
			this.salvar(new Concurso(1, "CAIXA ECONÔMICA"));
			this.salvar(new Concurso(2, "BANCO DO BRASIL"));
			this.salvar(new Concurso(3, "UFRJ"));
			this.salvar(new Concurso(4, "BNDES"));

			retorno = super.lerTodos();
		}

		return retorno;
	}

}
