package com.example.demo.service;

import com.example.demo.repository.model.Producto;
import com.example.demo.service.TO.ProductoTO;

public interface IProductoService {
	
	void insertar(ProductoTO productoTO);

	Producto buscarID(Integer id);

	Producto buscarporCodigoBarras(String numero);
}
