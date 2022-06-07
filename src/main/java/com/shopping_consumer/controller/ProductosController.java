package com.shopping_consumer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping_consumer.model.request.ClientesRequest;
import com.shopping_consumer.model.request.ProductosRequest;
import com.shopping_consumer.model.response.ProductosResponse;
import com.shopping_consumer.model.response.RepuestaCreacion;
import com.shopping_consumer.service.ConsumoProductosService;

@RestController
public class ProductosController {
	
	@Autowired
	private ConsumoProductosService productosService;
	
	@GetMapping("list-productos")
	public ResponseEntity<List<ProductosResponse>> getAllProductos(){
		try {
			
			return new ResponseEntity<List<ProductosResponse>>(productosService.obtenerTodosProductos(), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<ProductosResponse>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PostMapping("create-productos")
	public ResponseEntity<RepuestaCreacion> crearCliente(@RequestBody ProductosRequest request){
		try {
			
			return new ResponseEntity<RepuestaCreacion>(productosService.crearProducto(request), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<RepuestaCreacion>(new RepuestaCreacion(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
}
