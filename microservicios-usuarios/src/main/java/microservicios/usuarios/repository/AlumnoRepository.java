package microservicios.usuarios.repository;

import microservicios.usuarios.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
