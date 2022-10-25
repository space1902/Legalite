package com.legality_PQR.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.legality_PQR.dao.ILiderDao;
import com.legality_PQR.model.Lider;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.response.LiderResponseRest;

@Service
public class LiderServiceImpl implements ILiderService{
	
	@Autowired
	private ILiderDao liderDao;

	@Override
	public ResponseEntity<LiderResponseRest> createLider(Lider lider) {

		LiderResponseRest response = new LiderResponseRest();
		List<Lider> list = new ArrayList<>();

		try {
			Lider liderSaved = liderDao.save(lider);

			if(liderSaved != null) {

				list.add(liderSaved);
				response.getLiderResponse().setLider(list);
				response.setMetadata("Respuesta ok", "00", "Lider creado correctamente");

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Lider no creado");
				return new ResponseEntity<LiderResponseRest>(response, HttpStatus.BAD_REQUEST);
			}


		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al crear al Lider");
			e.getStackTrace();
			return new ResponseEntity<LiderResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<LiderResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<LiderResponseRest> deleteLider(Long id) {

		LiderResponseRest response = new LiderResponseRest();

		try {

			liderDao.deleteById(id);

			response.setMetadata("Respuesta ok", "00", "Eliminacion Exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Eliminacion no exitosa");
			e.getStackTrace();
			return new ResponseEntity<LiderResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<LiderResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<LiderResponseRest> updateLider(Long id, Lider lider) {

		LiderResponseRest response = new LiderResponseRest();
		List<Lider> list = new ArrayList<>();

		try {

			Optional<Lider> searchId = liderDao.findById(id);

			if(searchId.isPresent()) {

				searchId.get().setCorreo(lider.getCorreo());
				searchId.get().setGrupo(lider.getGrupo());
				searchId.get().setNombre(lider.getNombre());

				Lider clienteSaved = liderDao.save(searchId.get());

				if(clienteSaved != null) {

					list.add(clienteSaved);
					response.getLiderResponse().setLider(list);
					response.setMetadata("Respuesta ok", "00", "Lider actualizado");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Lider no actualizado");
					return new ResponseEntity<LiderResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Lider no encontrado");
				return new ResponseEntity<LiderResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar Lider");
			e.getStackTrace();
			return new ResponseEntity<LiderResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<LiderResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<LiderResponseRest> GetLider(Long id) {
		
		LiderResponseRest response = new LiderResponseRest();
		List<Lider> list = new ArrayList<>();

		try {

			Optional<Lider> cliente = liderDao.findById(id);

			if(cliente.isPresent()) {
				list.add(cliente.get());
				response.getLiderResponse().setLider(list);
				response.setMetadata("Respuesta ok", "00", "Lider encontrada");
			}else {

				response.setMetadata("Respuesta no ok", "-1", "Lider no encontrada");
				return new ResponseEntity<LiderResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al buscar al Lider");
			e.getStackTrace();
			return new ResponseEntity<LiderResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<LiderResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<LiderResponseRest> GetLideres() {

		LiderResponseRest response = new LiderResponseRest();

		try {

			List<Lider> cliente = (List<Lider>) liderDao.findAll();

			response.getLiderResponse().setLider(cliente);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
			e.getStackTrace();
			return new ResponseEntity<LiderResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<LiderResponseRest>(response, HttpStatus.OK);
	}

	
	

}
