package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Concurso;
import modelo.Inscricao;
import modelo.util.JpaDAO;

public class InscricaoDAO extends JpaDAO<Inscricao> {

	public InscricaoDAO() {
		super();
	}

	public InscricaoDAO(EntityManager manager) {
		super(manager);
	}

	public Inscricao lerPorCpfConcurso(String cpf, Concurso concurso)
	{
		Inscricao retorno = null;
		
		String comando = "from Inscricao c where c.cpf = :paramCpf  and c.concurso.id = :paramId";
		TypedQuery<Inscricao> query = this.getEntityManager().createQuery(comando, Inscricao.class);
		
		query.setParameter("paramCpf", cpf);
		query.setParameter("paramId", concurso.getCodigoConcurso());
		
		try {
			retorno = query.getSingleResult();
		} catch (Exception e) {
		//	retorno = null;
		}
		
		return retorno;
	}

	public List<Inscricao> lerPorConcurso(Concurso concurso)
	{
		List<Inscricao> retorno = null;
		
		String comando = "from Inscricao c where c.concurso.id = :paramId  order by c.nome";
		TypedQuery<Inscricao> query = this.getEntityManager().createQuery(comando, Inscricao.class);
		
		query.setParameter("paramId", concurso.getCodigoConcurso());
		
		try {
			retorno = query.getResultList();
		} catch (Exception e) {
		//	retorno = null;
		}
		
		return retorno;
	}

}
