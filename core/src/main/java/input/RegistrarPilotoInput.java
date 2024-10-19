package input;

import java.time.LocalDate;
import java.util.UUID;

public interface RegistrarPilotoInput {

    UUID crear(String nombre, String documento, LocalDate fechaNacimiento);
}
