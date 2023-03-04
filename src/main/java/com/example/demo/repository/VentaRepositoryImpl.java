package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Venta;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Venta venta) {
		this.entityManager.persist(venta);
	}

	@Override
	public void actualizar(Venta venta) {
		this.entityManager.merge(venta);
	}

}
