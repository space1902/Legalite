package com.legality_PQR.services;

import org.springframework.http.ResponseEntity;

import com.legality_PQR.model.Lider;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.response.LiderResponseRest;

public interface ILiderService {


	public ResponseEntity<LiderResponseRest> createLider(Lider lider);
	public ResponseEntity<LiderResponseRest> deleteLider(Long id);
	public ResponseEntity<LiderResponseRest> updateLider(Long id, Lider lider);
	public ResponseEntity<LiderResponseRest> GetLider(Long id);
	public ResponseEntity<LiderResponseRest> GetLideres();
	
	
}
