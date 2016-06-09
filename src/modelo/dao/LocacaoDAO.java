package modelo.dao;

import javax.persistence.EntityManager;

import modelo.dominio.Locacao;
import modelo.util.JpaDAO;

public class LocacaoDAO extends JpaDAO<Locacao> {
	
	public LocacaoDAO() {
		super();
	}

	public LocacaoDAO(EntityManager manager) {
		super(manager);
	}
}
