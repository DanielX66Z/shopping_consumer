package com.shopping_consumer.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdenesResponse {
	
	private Integer idOrdenes;
	private ClienteResponse clientes;
	private Integer cantidad;
	private Double total;
	@JsonProperty("productos")
	private ProductosResponse productos;

	
	public Integer getIdOrdenes() {
		return idOrdenes;
	}
	public void setIdOrdenes(Integer idOrdenes) {
		this.idOrdenes = idOrdenes;
	}

	public ClienteResponse getClientes() {
		return clientes;
	}
	public void setClientes(ClienteResponse clientes) {
		this.clientes = clientes;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public ProductosResponse getProductos() {
		return productos;
	}
	public void setProductos(ProductosResponse productos) {
		this.productos = productos;
	}
	
	
	
	

}
