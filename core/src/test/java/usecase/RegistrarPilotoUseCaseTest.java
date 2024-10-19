package usecase;

import input.RegistrarPilotoInput;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.RegistrarPilotoOutput;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegistrarPilotoUseCaseTest {

    RegistrarPilotoInput registrarPilotoInput;
    @Mock
    RegistrarPilotoOutput registrarPilotoOutput;
    UUID uuid = UUID.randomUUID();

    @BeforeEach
    void setup() {
        registrarPilotoInput = new RegistrarPilotoUseCase(registrarPilotoOutput);
    }

    @Test
    public void testRegistrarPiloto() {
        Piloto piloto = Piloto.Instancia(null,"Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16));
        when(registrarPilotoOutput.existeDocumento("123456ABC")).thenReturn(false);
        when(registrarPilotoOutput.crear(any(Piloto.class))).thenReturn(uuid);
        UUID pilotoRecibido = registrarPilotoInput.crear("Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16));
        Assertions.assertEquals(uuid, pilotoRecibido);
    }

    @Test
    public void testNoregistrarPiloto() {
        Piloto piloto = Piloto.Instancia(null,"Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16));
        when(registrarPilotoOutput.existeDocumento("123456ABC")).thenReturn(true);
        Assertions.assertThrows(Exception.class, () -> registrarPilotoInput.crear("Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16)));
    }

    @Test
    public void testNoSePudoRegistrarPiloto() {
        Piloto piloto = Piloto.Instancia(null,"Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16));
        when(registrarPilotoOutput.existeDocumento("123456ABC")).thenReturn(false);
        UUID pilotoRecibido = registrarPilotoInput.crear("Fanco Colapinto","123456ABC", LocalDate.of(1996,10,16));
        assertNull(pilotoRecibido);
        verify(registrarPilotoOutput,times(1)).crear(any(Piloto.class));
    }

}
