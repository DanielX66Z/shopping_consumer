package com.shopping_consumer.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class ClientesRequest {
	
	@NotNull(message = "Nombre es requerido")
	@Size(min=3, max=50, message = "Longitu de nombre debe ser {min} y {max} caracteres")
	@Valid
	private String nombre;
	@NotNull(message = "Direccion es requerido")
	@Size(min=5, max=150, message = "direccion no pueder deber tener una longitud {min} y un maximo de {max} caracteres")
	@Valid
	private String direccion;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	

}
