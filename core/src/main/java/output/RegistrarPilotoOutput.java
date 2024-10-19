package output;

import model.Piloto;

import java.util.UUID;

public interface RegistrarPilotoOutput {

    UUID crear(Piloto piloto);
    boolean existeDocumento(String documento);

}
