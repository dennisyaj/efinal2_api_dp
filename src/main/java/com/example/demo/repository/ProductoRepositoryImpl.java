package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Producto;

@Transactional
@Repository
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarID(Integer id) {
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public Producto buscarporCodigoBarras(String numero) {
		TypedQuery<Producto> query = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:numero", Producto.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
	}

}
