package com.shopping_consumer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping_consumer.model.request.ClientesRequest;
import com.shopping_consumer.model.response.ClienteResponse;
import com.shopping_consumer.model.response.RepuestaCreacion;
import com.shopping_consumer.service.ConsumoClientesService;

@CrossOrigin(origins = {"http://localhost:8081","http://localhost:4200"})
@RestController
public class ClientesController {

	
	@Autowired
	private ConsumoClientesService clientesService;
	
	
	@GetMapping("list-clientes")
	public ResponseEntity<List<ClienteResponse>> getAllClientes(){
		try {
			
			return new ResponseEntity<List<ClienteResponse>>(clientesService.obtenerTodosClientes(), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<ClienteResponse>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	@PostMapping("create-cliente")
	public ResponseEntity<RepuestaCreacion> crearCliente(@RequestBody @Valid ClientesRequest request){
		try {
			
			
			return new ResponseEntity<RepuestaCreacion>(clientesService.crearCliente(request), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<RepuestaCreacion>(new RepuestaCreacion(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
}
