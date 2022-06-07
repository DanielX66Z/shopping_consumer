package com.shopping_consumer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping_consumer.model.request.ClientesRequest;
import com.shopping_consumer.model.response.ClienteResponse;
import com.shopping_consumer.model.response.RepuestaCreacion;

@Service
public class ConsumoClientesService {
	
	private String urlBaseCore;
	private String listClientes;
	private String createCliente;

	public ClienteResponse enviarDatosGuardar(ClientesRequest request) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			String result = new ObjectMapper().writeValueAsString(request);

			HttpEntity<String> entity = new HttpEntity<>(result, headers);

			ClienteResponse clienteResponse = restTemplate.postForObject(urlBaseCore+listClientes, entity, ClienteResponse.class);
			return clienteResponse;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Obtiene datos del cliente
	 * 
	 * @return
	 */
	public List<ClienteResponse> obtenerTodosClientes() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			// consumo hacia CMC
			ClienteResponse[] clientes = restTemplate.getForObject(urlBaseCore+listClientes, ClienteResponse[].class);
	
			if(clientes!=null) {
				return Arrays.asList(clientes);
			}
			return new ArrayList<>();
		
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}
	
	
	public RepuestaCreacion crearCliente(ClientesRequest request) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			
			HttpEntity<Object> entity = new HttpEntity<>(request, headers);
			
			// consumo hacia CMC
			RepuestaCreacion clientes = restTemplate.postForObject(urlBaseCore+createCliente, entity, RepuestaCreacion.class);
	
			if(clientes!=null) {
				return clientes;
			}
			return null;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Value("${url_core}")
	public void setUrlBaseCore(String urlBaseCore) {
		this.urlBaseCore = urlBaseCore;
	}
	
	@Value("${list_cliente}")
	public void setListClientes(String listClientes) {
		this.listClientes = listClientes;
	}
	
	@Value("${insertar_cliente}")
	public void setCreateCliente(String createCliente) {
		this.createCliente= createCliente;
	}
	
	

}
