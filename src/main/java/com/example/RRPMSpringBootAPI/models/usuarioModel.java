package com.example.RRPMSpringBootAPI.models;


import jakarta.persistence.*;
/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;*/

@Entity // Para que de una clase simple de java pueda ser una entidad 
		// relacionada con una tabla y sus propiedades sean columnas
@Table(name = "usuario") //Crea tabla con ese nombre 
public class usuarioModel {
	
	@Id //Para que la BD sepa que es un ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Se genera automaticamente y se auto-incremente
	@Column(unique = true, nullable = false) //Es unico y no puede ser nulo
	private Long id;
	private String nombre;
	private String email;
	private Integer prioridad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
}
/*
Comando para correr por primera vez el proyecto para que cree las tablas
mvnnw.cmd spring-boot:run

update -> La tabla de datos se crea automaticamente y mapea las clases @Entity
none -> La tabla se crea manualmente

HOST
bbgubx8qflb4sqwtufee-mysql.services.clever-cloud.com

NAME
bbgubx8qflb4sqwtufee	

USER
u3o95rwgylsctpvp

PASSWORD
rGo42mA75XCdk5OEQVhM

PORT
3306

FLUJO DE TRABAJO
1- Controlador -> Aqui se recibe la peticion WEB
2- Service -> Ejecuta la logica de la aplicacion
3- El Servicio usa el Repositorio -> Hace las conexiones a la BD
4- El Repositorio -> utiliza el Modelo para saber que tipo de informacion traer

ORDEN de creacion
Model
Repository
Service
Controller
*/
