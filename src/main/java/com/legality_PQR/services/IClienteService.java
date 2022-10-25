package com.legality_PQR.services;

import org.springframework.http.ResponseEntity;

import com.legality_PQR.model.Cliente;
import com.legality_PQR.response.ClienteResponseRest;

public interface IClienteService {


	public ResponseEntity<ClienteResponseRest> createUsuario(Cliente cliente);
	public ResponseEntity<ClienteResponseRest> deleteUsuario(Long id);
	public ResponseEntity<ClienteResponseRest> updateUsuario(Long id, Cliente cliente);
	public ResponseEntity<ClienteResponseRest> GetUsuario(Long id);
	public ResponseEntity<ClienteResponseRest> GetUsuarios();
	
	
}
