package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVentaRepository;
import com.example.demo.repository.model.Producto;
import com.example.demo.repository.model.Venta;
import com.example.demo.service.TO.DetalleVentaTO;

@Service
public class VentaServiceImpl implements IVentaService {
	@Autowired
	private IVentaRepository iVentaRepository;

	@Autowired
	private IProductoService iProductoService;

	@Override
	public void insertar(Venta venta) {
		this.iVentaRepository.insertar(venta);
	}

	@Override
	public void actualizar(Venta venta) {
		this.iVentaRepository.actualizar(venta);
	}

	@Override
	public DetalleVentaTO agregar(String codigo, Integer cantida) {
		Producto p = this.iProductoService.buscarporCodigoBarras(codigo);
		DetalleVentaTO detalleVentaTO = new DetalleVentaTO();
		if (p.getStock() >= cantida) {
			detalleVentaTO.setCantidad(cantida);
			detalleVentaTO.setCodigoBarras(codigo);
			detalleVentaTO.setNombre(p.getNombre());
			detalleVentaTO.setPrecioUnitario(p.getPrecio());
			detalleVentaTO.setSubtotal(p.getPrecio().multiply(new BigDecimal(cantida)));
		}

		return detalleVentaTO;
	}

}
