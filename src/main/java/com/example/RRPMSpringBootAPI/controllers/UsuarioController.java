package com.example.RRPMSpringBootAPI.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RRPMSpringBootAPI.models.usuarioModel;
import com.example.RRPMSpringBootAPI.services.UsuarioService;

//@CrossOrigin(origins = "https://consumodeapi-front.web.app") //Solo permite el acceso a esta URL
@CrossOrigin(origins = "*") //Permite el acceso general
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<usuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	@PostMapping() //@ModelAttribute Usar para poder enviar datos del front al back
	public usuarioModel guardarUsuario(@ModelAttribute @RequestBody usuarioModel usuario) { //@RequestBody asigna la solicitud WEB a clase JAVA
		return this.usuarioService.guardarUsuario(usuario);
	}
	@GetMapping(path = "/{id}") //path -> Su "camino" en el URL
	public Optional<usuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){ //@PathVariable -> Configurar variables dentro de los propios segmentos de la URL 
		return this.usuarioService.obtenerPorId(id);
	}
	@GetMapping(path = "/query") // "/query" -> significa que tenemos que pasar los parametros como "query params" es decir: query?prioridad=5
	public ArrayList<usuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){ // @RequestParam -> Manejar peticiones HHTP entrantes en Spring,
																											 // permite el mapeo de los parametros de la peticion a parametros de metodo
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "Se elimino el usuario con id" + id;
		}else{
			return "No se pudo eliminar el usuario con id" + id;
		}
	}
}
