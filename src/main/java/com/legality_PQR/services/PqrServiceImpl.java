package com.legality_PQR.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.legality_PQR.dao.IPqrDao;
import com.legality_PQR.model.Pqr;
import com.legality_PQR.response.PqrResponseRest;

@Service
public class PqrServiceImpl implements IPqrService{

	@Autowired
	private IPqrDao pqrDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<PqrResponseRest> search() {

		PqrResponseRest response = new PqrResponseRest();

		try {

			List<Pqr> pqr = (List<Pqr>) pqrDao.findAll();

			response.getPqrResponse().setPqr(pqr);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<PqrResponseRest> updateIdAsesorUrgencia(Pqr pqr, Long id) {

		PqrResponseRest response = new PqrResponseRest();
		List<Pqr> list = new ArrayList<>();

		try {

			Optional<Pqr> searchId = pqrDao.findById(id);

			if(searchId.isPresent()) {

				searchId.get().setIdAcesor(pqr.getIdAcesor());
				searchId.get().setUrgencia(pqr.getUrgencia());

				Pqr pqrIdAsesorUrgencia = pqrDao.save(searchId.get());

				if(pqrIdAsesorUrgencia != null) {
					list.add(pqrIdAsesorUrgencia);
					response.getPqrResponse().setPqr(list);
					response.setMetadata("Respuesta ok", "00", "Usuario actualizado");
				}else {

					response.setMetadata("Respuesta no ok", "-1", "Pqr no actualizadaa");
					return new ResponseEntity<PqrResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Pqr no encontrada");
				return new ResponseEntity<PqrResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar asesor y urgencia");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<PqrResponseRest> searchId(Long id) {


		PqrResponseRest response = new PqrResponseRest();
		List<Pqr> list = new ArrayList<>();

		try {

			Optional<Pqr> pqr = pqrDao.findById(id);

			if(pqr.isPresent()) {
				list.add(pqr.get());
				response.getPqrResponse().setPqr(list);
				response.setMetadata("Respuesta ok", "00", "Pqr encontrada");
			}else {

				response.setMetadata("Respuesta no ok", "-1", "pqr no encontrada");
				return new ResponseEntity<PqrResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al buscar la Pqr");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<PqrResponseRest> updateEstado(Long id) {

		Boolean status = true;

		PqrResponseRest response = new PqrResponseRest();
		List<Pqr> list = new ArrayList<>();

		try {

			Optional<Pqr> searchId = pqrDao.findById(id);

			if(searchId.isPresent()) {


				List<Pqr> pqr = (List<Pqr>) pqrDao.findAll();

				searchId.get().setEstado(status);

				Pqr pqrIdAsesorUrgencia = pqrDao.save(searchId.get());

				if(pqrIdAsesorUrgencia != null) {
					list.add(pqrIdAsesorUrgencia);
					response.getPqrResponse().setPqr(list);
					response.setMetadata("Respuesta ok", "00", "Estado actualizado Pqr finalizada");
				}else {

					response.setMetadata("Respuesta no ok", "-1", "Estado no actualizadaa");
					return new ResponseEntity<PqrResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Pqr no encontrada");
				return new ResponseEntity<PqrResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar estado");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<PqrResponseRest> savePqr(Pqr pqr) {

		PqrResponseRest response = new PqrResponseRest();
		List<Pqr> list = new ArrayList<>();
		try {
			pqr.setEstado(false);
			pqr.setFechaCreacion(new Date());
			Pqr pqrSaved = pqrDao.save(pqr);

			if(pqrSaved != null) {

				list.add(pqrSaved);
				response.getPqrResponse().setPqr(list);
				response.setMetadata("Respuesta ok", "00", "Pqr creada correctamente");

			}else {

				response.setMetadata("Respuesta no ok", "-1", "pqr no creada");
				return new ResponseEntity<PqrResponseRest>(response, HttpStatus.BAD_REQUEST);
			}


		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al crear pqr");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<PqrResponseRest> deletePqr(Long id) {


		PqrResponseRest response = new PqrResponseRest();

		try {

			pqrDao.deleteById(id);

			response.setMetadata("Respuesta ok", "00", "Eliminacion Exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Eliminacion no exitosa");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PqrResponseRest> updateEstadoDevuelto(Long id) {

		Boolean status = false;

		PqrResponseRest response = new PqrResponseRest();
		List<Pqr> list = new ArrayList<>();

		try {

			Optional<Pqr> searchId = pqrDao.findById(id);

			if(searchId.isPresent()) {

				searchId.get().setEstado(status);

				Pqr pqrIdAsesorUrgencia = pqrDao.save(searchId.get());

				if(pqrIdAsesorUrgencia != null) {
					list.add(pqrIdAsesorUrgencia);
					response.getPqrResponse().setPqr(list);
					response.setMetadata("Respuesta ok", "00", "Estado actualizado Pqr devuelta");
				}else {

					response.setMetadata("Respuesta no ok", "-1", "Estado no actualizadaa");
					return new ResponseEntity<PqrResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Pqr no encontrada");
				return new ResponseEntity<PqrResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar estado");
			e.getStackTrace();
			return new ResponseEntity<PqrResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<PqrResponseRest>(response, HttpStatus.OK);
	}

}
