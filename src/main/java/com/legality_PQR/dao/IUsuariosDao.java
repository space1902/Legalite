package com.legality_PQR.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.legality_PQR.model.Usuarios;

public interface IUsuariosDao extends JpaRepository<Usuarios, Long>{
	
	@Query(
			value =" select count(*)"
					+ "	from usuarios "
					+ "	where correo = :email	",
			nativeQuery = true)
	Integer validateEmail(@Param("email") String email);
	
	@Query(
			value =" select count(*)"
					+ "	from usuarios "
					+ "	where password = :password	",
			nativeQuery = true)
	Integer validatePassword(@Param("password") String password);
	
	@Query(
			value =" select *"
					+ "	from usuarios "
					+ "	where cargo = :cargo	",
			nativeQuery = true)
	List<Usuarios>  getCargo(@Param("cargo") Long cargo);

	@Query(
			value =" select *"
					+ "	from usuarios "
					+ "	where id_user = :id	",
			nativeQuery = true)
	List<Usuarios>  getUsuario(@Param("id") Long id);

	@Query(
			value =" select *"
					+ "	from usuarios "
					+ "	where correo = :email	"
					+ " and password = :password ",
			nativeQuery = true)
	List<Usuarios>  getValidar(@Param("email") String email, @Param("password") String password);

}
