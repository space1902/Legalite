package com.legality_PQR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legality_PQR.model.Usuarios;
import com.legality_PQR.response.UsuariosResponseRest;
import com.legality_PQR.services.IUsuariosService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/legality/")
public class UsuariosRestController {
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@GetMapping("searchusers/")
	public ResponseEntity<UsuariosResponseRest> GetUsuarios(){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.GetUsuarios();

		return response;

	}

	@GetMapping("searchuser/{id}")
	public ResponseEntity<UsuariosResponseRest> GetUsuario(@PathVariable Long id){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.GetUsuario(id);

		return response;
	}

	@PutMapping("updateuser/{id}")
	public ResponseEntity<UsuariosResponseRest> updateUsuario(@PathVariable Long id, @RequestBody Usuarios usuarios){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.updateUsuario(id, usuarios);

		return response;

	}

	@PutMapping("updatemyuser/{id}")
	public ResponseEntity<UsuariosResponseRest> updateMyUsuario(@PathVariable Long id, @RequestBody Usuarios usuarios){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.updateUsuario(id, usuarios);

		return response;

	}

	@PutMapping("updatemypassword/{id}")
	public ResponseEntity<UsuariosResponseRest> updateMyPassword(@PathVariable Long id, String email, String password, String newpassword){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.updateMyPassword(id, email, password, newpassword);

		return response;

	}

	@PostMapping("createuser/")
	public ResponseEntity<UsuariosResponseRest> createUsuario(@RequestBody Usuarios usuarios){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.createUsuario(usuarios);

		return response;
	}

	@DeleteMapping("deleteuser/{id}")
	public ResponseEntity<UsuariosResponseRest> deleteUsuario(@PathVariable Long id){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.deleteUsuario(id);

		return response;
	}

	@GetMapping("searchcliente/{cargo}")
	public ResponseEntity<UsuariosResponseRest> getClient(@PathVariable Long cargo){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.getClient(cargo);

		return response;
	}

	@GetMapping("searchadmin/{cargo}")
	public ResponseEntity<UsuariosResponseRest> getAdmin(@PathVariable Long cargo){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.getAdmin(cargo);

		return response;
	}

	@GetMapping("searchasesor/{cargo}")
	public ResponseEntity<UsuariosResponseRest> getAsesor(@PathVariable Long cargo){

		ResponseEntity<UsuariosResponseRest> response = usuariosService.getAsesor(cargo);

		return response;
	}


}
