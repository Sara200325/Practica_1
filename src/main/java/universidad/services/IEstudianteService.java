package universidad.services;
import universidad.dtos.EstudianteDTO; 


import java.util.List;

public interface IEstudianteService {

    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO); 
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id);
    EstudianteDTO obtenerEstudiantePorId(Long id);


}
