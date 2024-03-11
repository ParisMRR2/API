package com.example.RRPMSpringBootAPI.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RRPMSpringBootAPI.models.usuarioModel;
import com.example.RRPMSpringBootAPI.repositories.UsuarioRepository;

@Service //Aqui va la logica del programa
public class UsuarioService {
	@Autowired	//No hay que instancearla, spring la usa automaticamente 
				//(inyeccion automatica de dependencias en clases que necesitan otros componentes)
	UsuarioRepository usuarioRepository;
	
	//Obtener todos los usuario de la Base de Datos
	public ArrayList<usuarioModel> obtenerUsuarios(){
		//Todos los posibles metodos en usuarioRepository.findAll() usuarioRepository.save(usuario) usuarioRepository.findById(id) etc
		//usuarioModel = JSON
		return (ArrayList<usuarioModel>) usuarioRepository.findAll();
	}
	public usuarioModel guardarUsuario(usuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	public Optional<usuarioModel> obtenerPorId(Long id){ //Si no existe el ID puede fallar, por eso ponemos que es de tipo Optional
		return usuarioRepository.findById(id);
	}
	public ArrayList<usuarioModel> obtenerPorPrioridad(Integer prioridad){
		return usuarioRepository.findByPrioridad(prioridad);
	}
	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch (Exception err) {
			return false;
		}
	}
}