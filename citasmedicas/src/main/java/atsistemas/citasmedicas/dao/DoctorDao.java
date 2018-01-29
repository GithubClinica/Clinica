package atsistemas.citasmedicas.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import atsistemas.citasmedicas.model.Doctor;

@Repository											// Mirar bien si es String o Integer que lo he cambiado por la id
public interface DoctorDao extends PagingAndSortingRepository <Doctor, String> {
	
	public Doctor findById(@Param(value = "id") String id);
	
	@Query("SELECT u FROM Doctor u WHERE upper(u.name) like :name "
								  + "AND upper(u.id) like :id")
	List<Doctor> findByCriteria(@Param("name") String name, 
								@Param("id") String id);


	//Devuelve el numero de consultas de un determinado doctor entre intervalo de fechas
	@Query(value= "SELECT COUNT (u.doctor) FROM Consulta u where u.doctor.id = :doctor "
														  + "AND u.fechaConsulta >= :initdate "
														  + "AND u.fechaConsulta <= :finishdate")
	public Integer consulbetweendate(@Param(value = "doctor") String id, 
									 @Param(value = "initdate") Date initdate, 
									 @Param(value = "finishdate") Date finishdate);
	
	@Query(value= "SELECT d.name,COUNT(DISTINCT cit.paciente.id) as u FROM Doctor d, Consulta con, Cita cit WHERE "
			+ "d.id=con.doctor.id AND con.id=cit.consulta.id GROUP BY d.id ORDER BY u DESC") 
//	public List<Doctor> findTopNByDoctorsWithMorePatients(@Param(value = "num") Integer num , Sort sort);
//	public List<Doctor> topdoctors();
	public Page<Doctor> topdoctors(Pageable pageable);
	
	
	
//	public List<Doctor> findAll(@Param(value = "page") String page, @Param(value = "size") String size);
	
//	public List<Doctor> findbyName (@Param(value = "name") String name);
	
//	public Doctor findbyEmail (@Param(value = "email") String email);
	
	/*
	//Recupera el usuario si alguno de sus libros que contengan title
	//select user.*
	//from user inner join book (book.idUser = user.id)
	//where idUser = ? and book.title like * %?% */
	
//	@Query (value = "select u from User as u INNER JOIN u.books as b where b.title like:title and u.id like:idUser")
//	List <User> findUserBooksLike(Integer idUser, String title);
	

}
