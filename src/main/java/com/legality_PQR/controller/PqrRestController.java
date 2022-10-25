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

import com.legality_PQR.model.Pqr;
import com.legality_PQR.response.PqrResponseRest;
import com.legality_PQR.services.IPqrService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/legality/")
public class PqrRestController {
	
	@Autowired
	private IPqrService pqrService;
	
	@GetMapping("searchpqr/")
	public ResponseEntity<PqrResponseRest> search(){
		
		ResponseEntity<PqrResponseRest> response = pqrService.search();
		
		return response;
		
	}
	
	@PutMapping("updateIdAsesorUrgencia/{id}")
	public ResponseEntity<PqrResponseRest> updateIdAsesorUrgencia(@RequestBody Pqr pqr, @PathVariable Long id){

		ResponseEntity<PqrResponseRest> response = pqrService.updateIdAsesorUrgencia(pqr, id);
		
		return response;
	}
	
	@GetMapping("searchpqr/{id}")
	public ResponseEntity<PqrResponseRest> searchId(@PathVariable Long id){
		
		ResponseEntity<PqrResponseRest> response = pqrService.searchId(id);
		
		return response;
		
	}
	
	@PutMapping("updatestado/{id}")
	public ResponseEntity<PqrResponseRest> updateEstado(@PathVariable Long id){

		ResponseEntity<PqrResponseRest> response = pqrService.updateEstado(id);
		
		return response;
	}
	
	@PostMapping("createpqr/")
	public ResponseEntity<PqrResponseRest> createPqr(@RequestBody Pqr pqr){

		ResponseEntity<PqrResponseRest> response = pqrService.savePqr(pqr);
		
		return response;
	}
	
	@DeleteMapping("deletepqr/{id}")
	public ResponseEntity<PqrResponseRest> deletePqr(@PathVariable Long id){

		ResponseEntity<PqrResponseRest> response = pqrService.deletePqr(id);
		
		return response;
	}
	
	@PutMapping("updatestadodevuelto/{id}")
	public ResponseEntity<PqrResponseRest> updateEstadoDevuelto(@PathVariable Long id){

		ResponseEntity<PqrResponseRest> response = pqrService.updateEstadoDevuelto(id);
		
		return response;
	}

}
