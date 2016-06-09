package modelo.dao;

import javax.persistence.EntityManager;

import modelo.dominio.Filme;
import modelo.util.JpaDAO;

public class FilmeDAO extends JpaDAO<Filme> {
	
	public FilmeDAO() {
		super();
	}

	public FilmeDAO(EntityManager manager) {
		super(manager);
	}
}
