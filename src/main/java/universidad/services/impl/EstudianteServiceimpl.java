package universidad.services.impl;
import universidad.dtos.EstudianteDTO;
import universidad.models.Estudiante;
import universidad.repository.EstudianteRepository;
import universidad.services.IEstudianteService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class EstudianteServiceimpl implements IEstudianteService{
    private final EstudianteRepository estudianteRepository;
    @Autowired
    public EstudianteServiceimpl(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }
    @PostConstruct
    public void init(){
        estudianteRepository.init();
    }
    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
            .map(this::convertirEstudianteADTO)
            .collect(Collectors.toList());
    }

    

    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiante estudiante = estudianteOptional.get();
            estudiante.setNombre(estudianteDTO.getNombre());
            estudiante.setApellido(estudianteDTO.getApellido());
            estudiante.setEmail(estudianteDTO.getEmail());
            estudiante.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
            estudiante.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());
            Estudiante estudianteActualizado = estudianteRepository.save(estudiante);
            return convertirEstudianteADTO(estudianteActualizado);
        } else {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
    }
    @Override
    public void eliminarEstudiante(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
        return convertirEstudianteADTO(estudiante);
    }

    /*
    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertirEstudianteADTO(estudiante));
        }
        return estudiantesDTO;
    }
    
*/
    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = convertirDTOaEstudiante(estudianteDTO);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return convertirEstudianteADTO(estudianteGuardado);
    }

    private EstudianteDTO convertirEstudianteADTO(Estudiante estudiante){
        return EstudianteDTO.builder()
            .id(estudiante.getId())
            .nombre(estudiante.getNombre())
            .apellido(estudiante.getApellido())
            .email(estudiante.getEmail())
            .fechaNacimiento(estudiante.getFechaNacimiento())
            .numeroInscripcion(estudiante.getNumeroInscripcion())
            .build();
    }

    private Estudiante convertirDTOaEstudiante(EstudianteDTO estudianteDTO){
        return Estudiante.builder()
            .id(estudianteDTO.getId())
            .nombre(estudianteDTO.getNombre())
            .apellido(estudianteDTO.getApellido())
            .email(estudianteDTO.getEmail())
            .fechaNacimiento(estudianteDTO.getFechaNacimiento())
            .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
            .build();
    }

    
}