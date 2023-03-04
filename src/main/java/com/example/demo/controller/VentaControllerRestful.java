package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Venta;
import com.example.demo.service.IProductoService;
import com.example.demo.service.IVentaService;
import com.example.demo.service.TO.BuscarTO;
import com.example.demo.service.TO.DetalleVentaTO;
import com.example.demo.service.TO.VentaTO;

@RestController
@RequestMapping("/ventas")
@CrossOrigin
public class VentaControllerRestful {
	@Autowired
	private IVentaService iVentaService;

	@Autowired
	private IProductoService iProductoService;

	@PostMapping
	private void ingresarVenta(Venta venta) {
		this.iVentaService.insertar(venta);
	}

	private Venta convertir(VentaTO ventaTO) {
		Venta venta = new Venta();
		venta.setCedulaCliente(ventaTO.getCedulaCliente());
		venta.setId(ventaTO.getId());
		venta.setListDetalleVentas(null);
		venta.setTotalVenta(null);
		return venta;
	}

	@GetMapping(path = "/{codigo}")
	private DetalleVentaTO obtenerProducto(@PathVariable("codigo") String codigo,
			@RequestParam("cantidad") Integer cantidad) {
		return this.iVentaService.agregar(codigo, cantidad);
	}

}
