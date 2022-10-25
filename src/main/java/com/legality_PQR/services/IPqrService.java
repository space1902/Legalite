package com.legality_PQR.services;

import org.springframework.http.ResponseEntity;

import com.legality_PQR.model.Pqr;
import com.legality_PQR.response.PqrResponseRest;

public interface IPqrService {
	
	public ResponseEntity<PqrResponseRest> search();
	public ResponseEntity<PqrResponseRest> updateIdAsesorUrgencia(Pqr pqr, Long id);
	public ResponseEntity<PqrResponseRest> searchId(Long id);
	public ResponseEntity<PqrResponseRest> updateEstado(Long id);
	public ResponseEntity<PqrResponseRest> savePqr(Pqr pqr);
	public ResponseEntity<PqrResponseRest> deletePqr(Long id);
	public ResponseEntity<PqrResponseRest> updateEstadoDevuelto(Long id);
	

}
