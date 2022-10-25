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
import com.legality_PQR.model.Lider;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.response.LiderResponseRest;
import com.legality_PQR.services.ILiderService;

@RestController
@RequestMapping("/legality/")
public class LiderRestCOntroller {
	
	@Autowired
	private ILiderService liderservice;
	

	@GetMapping("searchlideres/")
	public ResponseEntity<LiderResponseRest> GetUsuarios(){

		ResponseEntity<LiderResponseRest> response = liderservice.GetLideres();

		return response;

	}

	@GetMapping("searchlider/{id}")
	public ResponseEntity<LiderResponseRest> GetUsuario(@PathVariable Long id){

		ResponseEntity<LiderResponseRest> response = liderservice.GetLider(id);

		return response;
	}

	@PutMapping("updatelider/{id}")
	public ResponseEntity<LiderResponseRest> updateUsuario(@PathVariable Long id, @RequestBody Lider lider){

		ResponseEntity<LiderResponseRest> response = liderservice.updateLider(id, lider);

		return response;

	}

	@PostMapping("createlider/")
	public ResponseEntity<LiderResponseRest> createUsuario(@RequestBody Lider lider){

		ResponseEntity<LiderResponseRest> response = liderservice.createLider(lider);

		return response;
	}

	@DeleteMapping("deletelider/{id}")
	public ResponseEntity<LiderResponseRest> deleteUsuario(@PathVariable Long id){

		ResponseEntity<LiderResponseRest> response = liderservice.deleteLider(id);

		return response;
	}


}
