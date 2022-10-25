package com.legality_PQR.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.legality_PQR.dao.IClienteDao;
import com.legality_PQR.model.Cliente;
import com.legality_PQR.model.Pqr;
import com.legality_PQR.response.ClienteResponseRest;
import com.legality_PQR.response.PqrResponseRest;

@Service
public class ClienteServiceImpl implements IClienteService{

	private IClienteDao clienteDao;


	public ClienteServiceImpl(IClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public ResponseEntity<ClienteResponseRest> createUsuario(Cliente cliente) {

		ClienteResponseRest response = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();

		try {
			Cliente clienteSaved = clienteDao.save(cliente);

			if(clienteSaved != null) {

				list.add(clienteSaved);
				response.getClienteResponse().setCliente(list);
				response.setMetadata("Respuesta ok", "00", "Cliente creado correctamente");

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Cliente no creado");
				return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.BAD_REQUEST);
			}


		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al crear al cliente");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClienteResponseRest> deleteUsuario(Long id) {

		ClienteResponseRest response = new ClienteResponseRest();

		try {

			clienteDao.deleteById(id);

			response.setMetadata("Respuesta ok", "00", "Eliminacion Exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Eliminacion no exitosa");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClienteResponseRest> updateUsuario(Long id, Cliente cliente) {

		ClienteResponseRest response = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();

		try {

			Optional<Cliente> searchId = clienteDao.findById(id);

			if(searchId.isPresent()) {

				searchId.get().setCorreo(cliente.getCorreo());
				searchId.get().setDireccion(cliente.getDireccion());
				searchId.get().setNombre(cliente.getNombre());

				Cliente clienteSaved = clienteDao.save(searchId.get());

				if(clienteSaved != null) {

					list.add(clienteSaved);
					response.getClienteResponse().setCliente(list);
					response.setMetadata("Respuesta ok", "00", "Cliente actualizado");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Cliente no actualizado");
					return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			}else {

				response.setMetadata("Respuesta no ok", "-1", "Cliente no encontrado");
				return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al actualizar cliente");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClienteResponseRest> GetUsuario(Long id) {
		ClienteResponseRest response = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();

		try {

			Optional<Cliente> cliente = clienteDao.findById(id);

			if(cliente.isPresent()) {
				list.add(cliente.get());
				response.getClienteResponse().setCliente(list);
				response.setMetadata("Respuesta ok", "00", "Cliente encontrada");
			}else {

				response.setMetadata("Respuesta no ok", "-1", "Cliente no encontrada");
				return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Error al buscar al Cliente");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClienteResponseRest> GetUsuarios() {

		ClienteResponseRest response = new ClienteResponseRest();

		try {

			List<Cliente> cliente = (List<Cliente>) clienteDao.findAll();

			response.getClienteResponse().setCliente(cliente);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ClienteResponseRest>(response, HttpStatus.OK);
	}

}
