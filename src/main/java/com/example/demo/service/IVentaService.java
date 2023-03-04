package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Venta;
import com.example.demo.service.TO.DetalleVentaTO;

public interface IVentaService {
	
	void insertar(Venta venta);

	void actualizar(Venta venta);

	DetalleVentaTO agregar(String codigo, Integer cantida);
}
