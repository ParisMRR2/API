package com.example.RRPMSpringBootAPI.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RRPMSpringBootAPI.models.usuarioModel;

@Repository	//Extends CrudRepository trae todos los metodos ya creados y solo agregamos nosotros un nuevo metodo que es para buscar por prioridad
public interface UsuarioRepository extends CrudRepository<usuarioModel, Long>{
	public abstract ArrayList<usuarioModel> findByPrioridad(Integer prioridad); //Este metodo no viene en "CrudRepository", es nuestro
	/* Debe tener el nombre correcto, podemos usar otros nombres que estén en el modelo
	   o clase creada del usuario, por ejemplo, podemos usar:
	   findByPrioridad
	   findByNombre
	   findByEmail
	   Solo debemos hacer un metodo ABSTRACT y springboot se encarga del nombre
	*/
}
