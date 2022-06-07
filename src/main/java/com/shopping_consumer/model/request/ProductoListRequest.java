package com.shopping_consumer.model.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;


public class ProductoListRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8547066227439178665L;
	private  List<ProductosRequest> productos;
	
	@JsonCreator
	public ProductoListRequest(List<ProductosRequest> productos) {
		this.productos= productos;
	}

	public List<ProductosRequest> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosRequest> productos) {
		this.productos = productos;
	}

	

	

}
