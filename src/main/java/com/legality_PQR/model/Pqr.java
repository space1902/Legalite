package com.legality_PQR.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pqr")
public class Pqr implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pqr")
	private Long idPqr;
	
	@Column(name="asunto")
	private String asunto;
	private String cliente;
	private int urgencia;
	private String descripcion;
	private Date fechaCreacion;
	private Boolean estado;
    @Column(name="id_cliente")
    private Integer idCliente;
    @Column(name="id_asesor")
    private Integer idAcesor;
}
