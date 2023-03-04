package com.example.demo.repository;

import com.example.demo.repository.model.Producto;

public interface IProductoRepository {
	void insertar(Producto producto);

	void actualizar(Producto producto);

	Producto buscarID(Integer id);

	Producto buscarporCodigoBarras(String numero);
}
