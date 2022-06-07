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
import com.shopping_consumer.model.request.ProductosRequest;
import com.shopping_consumer.model.response.ClienteResponse;
import com.shopping_consumer.model.response.ProductosResponse;
import com.shopping_consumer.model.response.RepuestaCreacion;

@Service
public class ConsumoProductosService {
	
	private String urlBaseCore;
	private String listProductos;
	private String creacionProducto;
	
	/**
	 * Obtiene datos del cliente
	 * 
	 * @return
	 */
	public List<ProductosResponse> obtenerTodosProductos() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			// consumo hacia CMC
			ProductosResponse[] productos = restTemplate.getForObject(urlBaseCore+listProductos, ProductosResponse[].class);
	
			if(productos!=null) {
				return Arrays.asList(productos);
			}
			return new ArrayList<>();
		
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}
	
	
	public RepuestaCreacion crearProducto(ProductosRequest request) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			String result = new ObjectMapper().writeValueAsString(request);

			HttpEntity<Object> entity = new HttpEntity<>(result, headers);
			

			
			// consumo hacia CMC
			RepuestaCreacion clientes = restTemplate.postForObject(urlBaseCore+creacionProducto, entity, RepuestaCreacion.class);
	
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
	
	@Value("${list-productos}")
	public void setListProductos(String listProductos) {
		this.listProductos = listProductos;
	}
	
	@Value("${create-producto}")
	public void setCreacionProducto(String creacionProducto) {
		this.creacionProducto = creacionProducto;
	}
	
	

}
