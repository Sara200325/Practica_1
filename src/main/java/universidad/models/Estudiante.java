package universidad.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;


@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@Entity
@Table(name = "estudiantes")

public class Estudiante extends Persona {
    /*private String numeroInscripcion;*/
    @Column(name = "numero_inscripcion", unique = true)
    private String numeroInscripcion;
}