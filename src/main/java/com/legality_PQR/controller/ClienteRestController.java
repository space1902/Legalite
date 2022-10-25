package com.legality_PQR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legality_PQR.model.Cliente;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.services.IClienteService;

@RestController
@RequestMapping("/legality/")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;


	@GetMapping("searchusuarios/")
	public ResponseEntity<ClienteResponseRest> GetUsuarios(){

		ResponseEntity<ClienteResponseRest> response = clienteService.GetUsuarios();

		return response;

	}

	@GetMapping("searchusuario/{id}")
	public ResponseEntity<ClienteResponseRest> GetUsuario(@PathVariable Long id){

		ResponseEntity<ClienteResponseRest> response = clienteService.GetUsuario(id);

		return response;
	}

	@PutMapping("updateusuario/{id}")
	public ResponseEntity<ClienteResponseRest> updateUsuario(@PathVariable Long id, @RequestBody Cliente cliente){

		ResponseEntity<ClienteResponseRest> response = clienteService.updateUsuario(id, cliente);

		return response;

	}

	@PostMapping("createusuario/")
	public ResponseEntity<ClienteResponseRest> createUsuario(@RequestBody Cliente cliente){

		ResponseEntity<ClienteResponseRest> response = clienteService.createUsuario(cliente);

		return response;
	}

	@DeleteMapping("deleteusuario/{id}")
	public ResponseEntity<ClienteResponseRest> deleteUsuario(@PathVariable Long id){

		ResponseEntity<ClienteResponseRest> response = clienteService.deleteUsuario(id);

		return response;
	}

}
