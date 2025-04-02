
package universidad.repository;
import universidad.models.Estudiante;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository

public class EstudianteRepository {
    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>();
    private final AtomicLong idContador = new AtomicLong(); 

    public Estudiante save(Estudiante estudiante) {
        if(estudiante.getId() == null) {
            estudiante.setId(idContador.getAndIncrement());
        }
    estudiantes.put(estudiante.getId(), estudiante);
    return estudiante;
    }

    public List<Estudiante> findAll() {
        return new ArrayList<>(estudiantes.values());
    }

    public void deleteById(Long id) {
        estudiantes.remove(id);
    }
    /*agregre el find */
    public Optional<Estudiante> findById(Long id) {
        return Optional.ofNullable(estudiantes.get(id));
    }
    public boolean existsById(Long id) {
        return estudiantes.containsKey(id);
    }
    
    public void init(){
        Estudiante estudiante1 = Estudiante.builder()
            .nombre("Juan")
            .apellido("Perez")
            .email("juan.perez@gmail.com")
            .fechaNacimiento(LocalDate.of(2000,5,15))
            .numeroInscripcion("S001")
            .build();

        Estudiante estudiante2= Estudiante.builder()
            .nombre("Maria")
            .apellido("Gomez")
            .email("maria.gonzales@gmail.com")
            .fechaNacimiento(LocalDate.of(2001,6,20))
            .numeroInscripcion("S002")
            .build();

        
        save(estudiante1);
        save(estudiante2);
    }
}
