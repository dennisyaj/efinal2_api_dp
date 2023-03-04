package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IProductoService;
import com.example.demo.service.TO.ProductoTO;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoControllerRestful {
	@Autowired
	private IProductoService iProductoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	private void ingresarProducto(@RequestBody ProductoTO productoTO) {
		this.iProductoService.insertar(productoTO);
	}

}
