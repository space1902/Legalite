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

import com.legality_PQR.model.Asesor;
import com.legality_PQR.model.Cliente;
import com.legality_PQR.response.AsesorResponseRest;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.services.IAsesorService;

@RestController
@RequestMapping("/legality/")
public class AsesorRestController {
	
	@Autowired
	private IAsesorService asesorService;
	
	@GetMapping("searchasesores/")
	public ResponseEntity<AsesorResponseRest> GetAsesores(){

		ResponseEntity<AsesorResponseRest> response = asesorService.GetAsesores();

		return response;

	}

	@GetMapping("searchasesor/{id}")
	public ResponseEntity<AsesorResponseRest> GetAsesor(@PathVariable Long id){

		ResponseEntity<AsesorResponseRest> response = asesorService.GetAsesor(id);

		return response;
	}

	@PutMapping("updateasesor/{id}")
	public ResponseEntity<AsesorResponseRest> updateAsesor(@PathVariable Long id, @RequestBody Asesor asesor){

		ResponseEntity<AsesorResponseRest> response = asesorService.updateAsesor(id, asesor);

		return response;

	}

	@PostMapping("createasesor/")
	public ResponseEntity<AsesorResponseRest> createAsesor(@RequestBody Asesor asesor){

		ResponseEntity<AsesorResponseRest> response = asesorService.createAsesor(asesor);

		return response;
	}

	@DeleteMapping("deleteasesor/{id}")
	public ResponseEntity<AsesorResponseRest> deleteAsesor(@PathVariable Long id){

		ResponseEntity<AsesorResponseRest> response = asesorService.deleteAsesor(id);

		return response;
	}


}
