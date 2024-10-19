package model;

import exception.PilotoDocumentoNoValidoException;
import exception.PilotoFechaNacimientoNoValidoException;
import exception.PilotoNombreNoValidoException;

import java.time.LocalDate;
import java.util.UUID;

public class Piloto {
    private UUID id;
    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;

    private Piloto(UUID id, String nombre, String documento, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Piloto Instancia(UUID id, String nombre, String documento, LocalDate fechaNacimiento) {
        if(nombre == null || nombre.isBlank())
            throw new PilotoNombreNoValidoException("Nombre no valido");
        if(documento == null || documento.isBlank())
            throw new PilotoDocumentoNoValidoException("Documento no valido");
        if(fechaNacimiento == null  || LocalDate.now().getYear() - fechaNacimiento.getYear() < 18)
            throw new PilotoFechaNacimientoNoValidoException("Fecha de Nacimiento no valido");
        return new Piloto(id, nombre, documento, fechaNacimiento);
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
