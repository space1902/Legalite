package com.legality_PQR.services;

import org.springframework.http.ResponseEntity;

import com.legality_PQR.model.Usuarios;
import com.legality_PQR.response.UsuariosResponseRest;

public interface IUsuariosService {


	public ResponseEntity<UsuariosResponseRest> createUsuario(Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> deleteUsuario(Long id);
	public ResponseEntity<UsuariosResponseRest> updateUsuario(Long id, Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> updateMyUsuario(Long id, Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> updateMyPassword(Long id, String email, String password, String newpassword);
	public ResponseEntity<UsuariosResponseRest> GetUsuario(Long id);
	public ResponseEntity<UsuariosResponseRest> GetUsuarios();
	public ResponseEntity<UsuariosResponseRest> getAsesor(Long cargo);
	public ResponseEntity<UsuariosResponseRest> getAdmin(Long cargo);
	public ResponseEntity<UsuariosResponseRest> getClient(Long cargo);
	
	
}
