package com.legality_PQR.services;

import org.springframework.http.ResponseEntity;

import com.legality_PQR.model.Asesor;
import com.legality_PQR.response.AsesorResponseRest;

public interface IAsesorService {


	public ResponseEntity<AsesorResponseRest> createAsesor(Asesor asesor);
	public ResponseEntity<AsesorResponseRest> deleteAsesor(Long id);
	public ResponseEntity<AsesorResponseRest> updateAsesor(Long id, Asesor asesor);
	public ResponseEntity<AsesorResponseRest> GetAsesor(Long id);
	public ResponseEntity<AsesorResponseRest> GetAsesores();
	
	
}
