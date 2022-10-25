package com.legality_PQR.response;

import java.util.List;
import java.util.Optional;

import com.legality_PQR.model.Pqr;


public class PqrResponse {

	private List<Pqr> pqr;

	public List<Pqr> getPqrs() {
		return pqr;
	}

	public void setPqr(List<Pqr> pqr) {
		this.pqr = pqr;
	}

}
