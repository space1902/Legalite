package com.legality_PQR.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.legality_PQR.dao.IAsesorDao;
import com.legality_PQR.dao.IClienteDao;
import com.legality_PQR.model.Asesor;
import com.legality_PQR.model.Cliente;
import com.legality_PQR.model.Pqr;
import com.legality_PQR.response.AsesorResponseRest;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.response.PqrResponseRest;

@Service
public class AsesorServiceImpl implements IAsesorService{

	private IAsesorDao asesorDao;

	public AsesorServiceImpl(IAsesorDao asesorDao) {
		this.asesorDao = asesorDao;
	}

	@Override
	public ResponseEntity<AsesorResponseRest> createAsesor(Asesor asesor) {

		AsesorResponseRest response = new AsesorResponseRest();
		List<Asesor> list = new ArrayList<>();

		try {
			Asesor clienteSaved = asesorDao.save(asesor);

			if(clienteSaved != null) {

				list.add(clienteSaved);
				response.getAsesorResponse().setAsesor(list);;
				response.setMetadata("Respuesta ok", "00", "Asesor creado correctamente");

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Asesor no creado");
				return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.BAD_REQUEST);
			}


		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al crear al Asesor");
			e.getStackTrace();
			return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AsesorResponseRest> deleteAsesor(Long id) {

		AsesorResponseRest response = new AsesorResponseRest();

		try {

			asesorDao.deleteById(id);

			response.setMetadata("Respuesta ok", "00", "Eliminacion Exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Eliminacion no exitosa");
			e.getStackTrace();
			return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<AsesorResponseRest> updateAsesor(Long id, Asesor asesor) {

		AsesorResponseRest response = new AsesorResponseRest();
		List<Asesor> list = new ArrayList<>();

		try {

			Optional<Asesor> searchId = asesorDao.findById(id);

			if(searchId.isPresent()) {


				searchId.get().setCorreo(asesor.getCorreo());
				searchId.get().setGrupo(asesor.getGrupo());
				searchId.get().setNombre(asesor.getNombre());

				Asesor asesorSaved = asesorDao.save(searchId.get());

				if(asesorSaved != null) {

					list.add(asesorSaved);
					response.getAsesorResponse().setAsesor(list);
					response.setMetadata("Respuesta ok", "00", "Asesor actualizado");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Asesor no actualizado");
					return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Asesor no encontrado");
				return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar Asesor");
			e.getStackTrace();
			return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<AsesorResponseRest> GetAsesor(Long id) {
		AsesorResponseRest response = new AsesorResponseRest();
		List<Asesor> list = new ArrayList<>();

		try {

			Optional<Asesor> cliente = asesorDao.findById(id);

			if(cliente.isPresent()) {
				list.add(cliente.get());
				response.getAsesorResponse().setAsesor(list);
				response.setMetadata("Respuesta ok", "00", "Asesor encontrada");
			}else {

				response.setMetadata("Respuesta no ok", "-1", "Asesor no encontrada");
				return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al buscar al Asesor");
			e.getStackTrace();
			return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<AsesorResponseRest> GetAsesores() {

		AsesorResponseRest response = new AsesorResponseRest();

		try {

			List<Asesor> asesor = (List<Asesor>) asesorDao.findAll();

			response.getAsesorResponse().setAsesor(asesor);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
			e.getStackTrace();
			return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AsesorResponseRest>(response, HttpStatus.OK);
	}

	
}
