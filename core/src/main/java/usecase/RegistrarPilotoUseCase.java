package usecase;

import exception.ExisteDocumentoException;
import input.RegistrarPilotoInput;
import model.Piloto;
import output.RegistrarPilotoOutput;

import java.time.LocalDate;
import java.util.UUID;

public class RegistrarPilotoUseCase implements RegistrarPilotoInput{

    private final RegistrarPilotoOutput registrarPilotoOutput;

    public RegistrarPilotoUseCase(RegistrarPilotoOutput registrarPilotoOutput) {
        this.registrarPilotoOutput = registrarPilotoOutput;
    }

    @Override
    public UUID crear(String nombre, String documento, LocalDate fechaNacimiento) {
        if(registrarPilotoOutput.existeDocumento(documento))
            throw new ExisteDocumentoException("El documento existe");
        Piloto piloto = Piloto.Instancia(null,nombre,documento,fechaNacimiento);
        return registrarPilotoOutput.crear(piloto);
    }
}
