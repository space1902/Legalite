package com.legality_PQR.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.legality_PQR.model.Pqr;
import com.legality_PQR.model.Usuarios;

public interface IPqrDao extends JpaRepository<Pqr, Long>{
	

	@Query(
			value =" select *"
					+ "	from pqr "
					+ "	where id_asesor = :id ",
			nativeQuery = true)
	List<Pqr>  searchMyPqr(@Param("id") Long id);
	
	@Query(
			value =" select *"
					+ "	from pqr "
					+ "	where id_cliente = :nit ",
			nativeQuery = true)
	List<Pqr>  findMyPqr(@Param("nit") Long nit);
}
