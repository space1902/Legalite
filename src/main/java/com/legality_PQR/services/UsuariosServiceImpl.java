package com.legality_PQR.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.legality_PQR.dao.IUsuariosDao;
import com.legality_PQR.model.Usuarios;
import com.legality_PQR.response.UsuariosResponseRest;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	private IUsuariosDao usuarioDao;

	public UsuariosServiceImpl(IUsuariosDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> createUsuario(Usuarios usuarios) {

		UsuariosResponseRest response = new UsuariosResponseRest();
		List<Usuarios> list = new ArrayList<>();

		try {
			Usuarios clienteSaved = usuarioDao.save(usuarios);

			if(clienteSaved != null) {

				list.add(clienteSaved);
				response.getUsuarioResponse().setUsuarios(list);;
				response.setMetadata("Respuesta ok", "00", "Usuario creado correctamente");

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Usuario no creado");
				return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.BAD_REQUEST);
			}


		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al crear al Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> deleteUsuario(Long id) {

		UsuariosResponseRest response = new UsuariosResponseRest();

		try {

			usuarioDao.deleteById(id);

			response.setMetadata("Respuesta ok", "00", "Eliminacion Exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Eliminacion no exitosa");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> updateUsuario(Long id, Usuarios usuarios) {

		UsuariosResponseRest response = new UsuariosResponseRest();
		List<Usuarios> list = new ArrayList<>();

		try {

			Optional<Usuarios> searchId = usuarioDao.findById(id);

			if(searchId.isPresent()) {


				searchId.get().setCorreo(usuarios.getCorreo());
				searchId.get().setGrupo(usuarios.getGrupo());
				searchId.get().setNombre(usuarios.getNombre());
				searchId.get().setNit(usuarios.getNit());
				searchId.get().setContraseña(usuarios.getContraseña());
				searchId.get().setCargo(usuarios.getCargo());
				searchId.get().setDireccion(usuarios.getDireccion());

				Usuarios asesorSaved = usuarioDao.save(searchId.get());

				if(asesorSaved != null) {

					list.add(asesorSaved);
					response.getUsuarioResponse().setUsuarios(list);
					response.setMetadata("Respuesta ok", "00", "Usuario actualizado");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Usuario no actualizado");
					return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Usuario no encontrado");
				return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);

	}
	

	@Override
	public ResponseEntity<UsuariosResponseRest> updateMyUsuario(Long id, Usuarios usuarios) {

		UsuariosResponseRest response = new UsuariosResponseRest();
		List<Usuarios> list = new ArrayList<>();

		try {

			Optional<Usuarios> searchId = usuarioDao.findById(id);
			List<Usuarios> prueba = usuarioDao.getUsuario(id);

			if(searchId.isPresent()) {


				searchId.get().setCorreo(usuarios.getCorreo());
				searchId.get().setNombre(usuarios.getNombre());
				searchId.get().setDireccion(usuarios.getDireccion());

				Usuarios usuarioSaved = usuarioDao.save(searchId.get());

				if(usuarioSaved != null) {

					list.add(usuarioSaved);
					response.getUsuarioResponse().setUsuarios(list);
					response.setMetadata("Respuesta ok", "00", "Usuario actualizado");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Usuario no actualizado");
					return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Usuario no encontrado");
				return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<UsuariosResponseRest> GetUsuario(Long id) {
		UsuariosResponseRest response = new UsuariosResponseRest();
		List<Usuarios> list = new ArrayList<>();

		try {

			Optional<Usuarios> usuario = usuarioDao.findById(id);

			if(usuario.isPresent()) {
				list.add(usuario.get());
				response.getUsuarioResponse().setUsuarios(list);
				response.setMetadata("Respuesta ok", "00", "Usuario encontrada");
			}else {

				response.setMetadata("Respuesta no ok", "-1", "Usuario no encontrada");
				return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al buscar al Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<UsuariosResponseRest> GetUsuarios() {

		UsuariosResponseRest response = new UsuariosResponseRest();

		try {

			List<Usuarios> usuarios = (List<Usuarios>) usuarioDao.findAll();

			response.getUsuarioResponse().setUsuarios(usuarios);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> updateMyPassword(Long id,  Usuarios usuarios) {
		

		UsuariosResponseRest response = new UsuariosResponseRest();
		List<Usuarios> list = new ArrayList<>();
		try {

			Optional<Usuarios> searchId = usuarioDao.findById(id);
			Integer validateEm = usuarioDao.validateEmail(usuarios.getCorreo());
			Integer validatePass = usuarioDao.validatePassword(usuarios.getContraseña());

			if(searchId.isPresent() && validateEm == 1 && validatePass == 1) {

				System.out.println("ver lo que llega" + usuarios.getNuevacontraseña()); 

				searchId.get().setContraseña(usuarios.getNuevacontraseña());

				Usuarios usuarioSaved = usuarioDao.save(searchId.get());

				if(usuarioSaved != null) {

					list.add(usuarioSaved);
					response.getUsuarioResponse().setUsuarios(list);
					response.setMetadata("Respuesta ok", "00", "Usuario actualizado");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Usuario no actualizado");
					return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Usuario no encontrado");
				return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> getCargo(Long cargo) {

		UsuariosResponseRest response = new UsuariosResponseRest();

		try {

			List<Usuarios> usuarios = (List<Usuarios>) usuarioDao.getCargo(cargo);

			response.getUsuarioResponse().setUsuarios(usuarios);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> getValidarUsuario(String correo, String contraseña) {


		UsuariosResponseRest response = new UsuariosResponseRest();
		Usuarios list = new Usuarios();
		String correo1 =  correo;
		String contraseña2 = contraseña;
		System.out.println("lleg esto " + correo + contraseña );
		try {

			List<Usuarios> searchId = usuarioDao.getValidar(correo1,contraseña2);

			if(searchId.get(0).getContraseña() != null) {

				System.out.println("lleg esto " + searchId);
				response.getUsuarioResponse().setUsuarios(searchId);
				response.setMetadata("Respuesta ok", "00", "Usuario encontrado");

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Usuario no encontrado");
				return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al iniciar sesion");
			e.getStackTrace();
			return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

	
}
