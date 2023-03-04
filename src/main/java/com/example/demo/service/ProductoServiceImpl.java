package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.model.Producto;
import com.example.demo.service.TO.ProductoTO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void insertar(ProductoTO productoTO) {
		try {
			Producto prod = new Producto();
			prod = this.buscarporCodigoBarras(productoTO.getCodigoBarras());
			prod.setStock(prod.getStock() + productoTO.getStock());

		} catch (Exception e) {
			this.iProductoRepository.insertar(convertir(productoTO));
		}

	}

	private Producto convertir(ProductoTO productoTO) {
		Producto p = new Producto();
		p.setCategoria(productoTO.getCategoria());
		p.setCodigoBarras(productoTO.getCodigoBarras());
		p.setNombre(productoTO.getNombre());
		p.setPrecio(productoTO.getPrecio());
		p.setStock(productoTO.getStock());
		return p;
	}

	@Override
	public Producto buscarID(Integer id) {
		return this.iProductoRepository.buscarID(id);
	}

	@Override
	public Producto buscarporCodigoBarras(String numero) {
		return this.iProductoRepository.buscarporCodigoBarras(numero);
	}

}
