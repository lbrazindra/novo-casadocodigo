package br.com.casadocodigo.loja.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.modelo.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> list() {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos", Produto.class)
				.getResultList();
	}

	public Produto find(Integer id) {
		TypedQuery<Produto> query = manager
				.createQuery("select distinct(p) from Produto p join fetch p.prices where p.id=:id", Produto.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}

}
