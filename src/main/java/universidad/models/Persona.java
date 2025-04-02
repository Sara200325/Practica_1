package universidad.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@MappedSuperclass

public abstract class Persona {
    /*private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
}
