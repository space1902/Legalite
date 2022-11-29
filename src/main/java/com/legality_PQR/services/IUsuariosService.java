package com.legality_PQR.services;

import org.springframework.http.ResponseEntity;

import com.legality_PQR.model.Usuarios;
import com.legality_PQR.response.UsuariosResponseRest;

public interface IUsuariosService {


	public ResponseEntity<UsuariosResponseRest> createUsuario(Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> deleteUsuario(Long id);
	public ResponseEntity<UsuariosResponseRest> updateUsuario(Long id, Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> updateMyUsuario(Long id, Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> updateMyPassword(Long id, Usuarios usuarios);
	public ResponseEntity<UsuariosResponseRest> GetUsuario(Long id);
	public ResponseEntity<UsuariosResponseRest> GetUsuarios();
	public ResponseEntity<UsuariosResponseRest> getCargo(Long cargo);
	public ResponseEntity<UsuariosResponseRest> getValidarUsuario(String correo, String contraseña);
	
	
}
