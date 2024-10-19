package model;

import exception.PilotoDocumentoNoValidoException;
import exception.PilotoFechaNacimientoNoValidoException;
import exception.PilotoNombreNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PilotoTest {

    @Test
    public void test_Instancia() {
        Piloto piloto = Piloto.Instancia(null,"Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16));
        assertNotNull(piloto);
    }

    @Test
    public void test_Nombre_Exception() {
        RuntimeException exception1 = Assertions.assertThrows(PilotoNombreNoValidoException.class, () -> Piloto.Instancia(null,"","123456ABC", LocalDate.of(2000,10,15)));
        RuntimeException exception2 = Assertions.assertThrows(PilotoNombreNoValidoException.class, () -> Piloto.Instancia(null,null,"123456ABC", LocalDate.of(2000,10,15)));
        Assertions.assertEquals("Nombre no valido",exception1.getMessage());
        Assertions.assertEquals("Nombre no valido",exception2.getMessage());
    }

    @Test
    public void test_Documento_Exception() {
        RuntimeException exception1 = Assertions.assertThrows(PilotoDocumentoNoValidoException.class, () -> Piloto.Instancia(null,"Fanco Colapinto",null, LocalDate.of(2000,10,15)));
        RuntimeException exception2 = Assertions.assertThrows(PilotoDocumentoNoValidoException.class, () -> Piloto.Instancia(null,"Fanco Colapinto","", LocalDate.of(2000,10,15)));
        Assertions.assertEquals("Documento no valido",exception1.getMessage());
        Assertions.assertEquals("Documento no valido",exception2.getMessage());
    }

    @Test
    public void test_FechaNacimiento_Exception() {
        RuntimeException exception1 = Assertions.assertThrows(PilotoFechaNacimientoNoValidoException.class, ()-> Piloto.Instancia(null,"Fanco Colapinto","123456ABC", null));
        RuntimeException exception3 = Assertions.assertThrows(PilotoFechaNacimientoNoValidoException.class, ()-> Piloto.Instancia(null,"Fanco Colapinto","123456ABC", LocalDate.of(2007,10,15)));
        Assertions.assertEquals("Fecha de Nacimiento no valido",exception1.getMessage());
        Assertions.assertEquals("Fecha de Nacimiento no valido",exception3.getMessage());
    }


}
