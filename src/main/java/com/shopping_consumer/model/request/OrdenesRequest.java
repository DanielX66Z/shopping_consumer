package com.shopping_consumer.model.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "idCliente", "cantidad", "total","productos" })
public class OrdenesRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1762593521632290406L;
	@NotNull(message = "Cliente es requerido")
	@Valid
	private Integer idCliente;
	@NotNull(message = "cantidad es requerido")
	@Valid
	private Double cantidad;
	@NotNull(message = "Total es requerido")
	@Valid
	private Double total;
	
	@ConvertGroup(from = OrdenesRequest.class, to=ProductosRequest.class)
	private List<ProductosRequest> productos;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<ProductosRequest> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductosRequest> productos) {
		this.productos = productos;
	}

	

	
	
	

}
