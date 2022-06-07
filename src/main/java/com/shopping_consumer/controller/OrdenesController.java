package com.shopping_consumer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shopping_consumer.model.request.ClientesRequest;
import com.shopping_consumer.model.request.OrdenesRequest;
import com.shopping_consumer.model.response.ClienteResponse;
import com.shopping_consumer.model.response.OrdenesResponse;
import com.shopping_consumer.model.response.RepuestaCreacion;
import com.shopping_consumer.service.OrdenesProductosService;

@RestController
public class OrdenesController {
	
	@Autowired
	OrdenesProductosService ordenesService;
	
	@GetMapping("list-ordenes")
	public ResponseEntity<List<OrdenesResponse>> getAllClientes(){
		try {
			
			return new ResponseEntity<List<OrdenesResponse>>(ordenesService.obtenerTodasOrdenes(), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<OrdenesResponse>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PostMapping("create-orden")
	public ResponseEntity<RepuestaCreacion> crearCliente(@RequestBody  OrdenesRequest request) throws  IllegalArgumentException, SecurityException, JsonProcessingException{
		try {
			System.out.println("entro a crear");
			return new ResponseEntity<RepuestaCreacion>(ordenesService.enviarDatosGuardar(request), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<RepuestaCreacion>(new RepuestaCreacion(), HttpStatus.BAD_REQUEST);
			
		}
	}
}
