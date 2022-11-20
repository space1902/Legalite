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
@Table(name = "usuarios")
public class Usuarios {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long idUser;
	
	@Column(name="nit")
	private String nit;
	private String nombre;
	private Integer tipo_usuario;
	private String contraseña;
	private String correo;
	private String cargo;
	private String direccion;
	private Integer grupo;
}
