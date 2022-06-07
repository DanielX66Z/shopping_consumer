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
import com.shopping_consumer.model.request.OrdenesRequest;
import com.shopping_consumer.model.response.OrdenesResponse;
import com.shopping_consumer.model.response.RepuestaCreacion;

@Service
public class OrdenesProductosService {
	
	private String urlBaseCore;
	private String listOrdenes;
	private String agregarOrden;
	
	
	/**
	 * Obtiene datos de ordenes
	 * 
	 * @return
	 */
	public List<OrdenesResponse> obtenerTodasOrdenes() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			// consumo hacia CMC
			OrdenesResponse[] productos = restTemplate.getForObject(urlBaseCore+listOrdenes, OrdenesResponse[].class);
	
			if(productos!=null) {
				return Arrays.asList(productos);
			}
			return new ArrayList<>();
		
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}
	
	
	public RepuestaCreacion enviarDatosGuardar(OrdenesRequest request) {
		try {
			System.out.println("entra ahi");
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			String result = new ObjectMapper().writeValueAsString(request);
			HttpEntity<String> entity = new HttpEntity<>(result, headers);

			return restTemplate.postForObject(urlBaseCore+agregarOrden, entity, RepuestaCreacion.class);
		} catch (Exception e) {
			return null;
		}

	}
	
	@Value("${url_core}")
	public void setUrlBaseCore(String urlBaseCore) {
		this.urlBaseCore = urlBaseCore;
	}
	
	@Value("${list-ordenes}")
	public void setListProductos(String listOrdenes) {
		this.listOrdenes = listOrdenes;
	}
	
	@Value("${crear-orden}")
	public void setAgregarOrden(String agregarOrden) {
		this.agregarOrden = agregarOrden;
	}
	
	
}
