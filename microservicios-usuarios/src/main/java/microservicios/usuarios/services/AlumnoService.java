package microservicios.usuarios.services;

import microservicios.common.services.CommonService;
import microservicios.usuarios.entity.Alumno;

import java.util.Optional;

public interface AlumnoService extends CommonService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);

}

