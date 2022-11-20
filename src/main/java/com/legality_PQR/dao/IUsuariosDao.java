package com.legality_PQR.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.legality_PQR.model.Usuarios;

public interface IUsuariosDao extends JpaRepository<Usuarios, Long>{
	
	@Query(
			value =" select count(*)"
					+ "	from usuarios "
					+ "	where contraseña = :email	",
			nativeQuery = true)
	Integer validateEmail(@Param("email") String email);
	
	@Query(
			value =" select count(*)"
					+ "	from usuarios "
					+ "	where correo = :password	",
			nativeQuery = true)
	Integer validatePassword(@Param("password") String password);
	
	@Query(
			value =" select *"
					+ "	from usuarios "
					+ "	where cargo = :cargo	",
			nativeQuery = true)
	List<Usuarios> getClient(@Param("cargo") Long cargo);
	
	@Query(
			value =" select *"
					+ "	from usuarios "
					+ "	where cargo = :cargo	",
			nativeQuery = true)
	List<Usuarios>  getAdmin(@Param("cargo") Long cargo);
	
	@Query(
			value =" select *"
					+ "	from usuarios "
					+ "	where cargo = :cargo	",
			nativeQuery = true)
	List<Usuarios>  getAsesor(@Param("cargo") Long cargo);

}
