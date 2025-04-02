package universidad.controllers;
import universidad.dtos.EstudianteDTO;
import universidad.services.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EstudianteController {
    private final IEstudianteService estudianteService;
    @Autowired
    public EstudianteController(IEstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }
    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes(){
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    
    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO nuevoEstudiante = estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.status(201).body(nuevoEstudiante); // Devuelve un código HTTP 201 (Created)
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteDTO);
        return ResponseEntity.ok(estudianteActualizado); // Devuelve un código HTTP 200 (OK)
    }
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build(); // Devuelve un código HTTP 204 (No Content)
    } 
    /*
    @UpdateMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(estudianteDTO);
        return ResponseEntity.ok(estudianteActualizado);
    }
    
       
            
    */

}


