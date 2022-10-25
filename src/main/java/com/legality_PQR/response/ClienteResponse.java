package com.legality_PQR.response;

import java.util.List;

import com.legality_PQR.model.Asesor;
import com.legality_PQR.model.Cliente;
import com.legality_PQR.model.Lider;

public class ClienteResponse {

	private List<Cliente> cliente;

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

}
