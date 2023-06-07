package microservicios.usuarios.controllers;

import microservicios.usuarios.entity.Alumno;
import microservicios.usuarios.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoRepository service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnoDB = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDB);
    }

    @GetMapping
    public ResponseEntity<Iterable<Alumno>> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> o = service.findById(id);

        if(o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = o.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}