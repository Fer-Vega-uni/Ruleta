package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RuletaTest {

    private IRepositorioResultados repoMock;
    @BeforeEach
    void setUp() {
        repoMock = new RepositorioEnMemoria();
    }

    @Test
    void testConstructorSaldoNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Ruleta(repoMock, -100);
        });
        assertEquals("Saldo inicial inválido", exception.getMessage());
    }

    @Test
    void testDepositarIncrementaSaldo() {
        Ruleta ruleta = new Ruleta(repoMock, 1000);
        ruleta.depositar(500);
        assertEquals(1500, ruleta.getSaldo(), "El saldo debería ser 1500 (1000+500)");
    }

    @Test
    void testJugarApuestaNula() {
        Ruleta ruleta = new Ruleta(repoMock, 1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ruleta.jugarRonda(null);
        });
        assertEquals("Apuesta requerida", exception.getMessage());
    }

    @Test
    void testJugarSaldoInsuficiente() {
        Ruleta ruleta = new Ruleta(repoMock, 100);
        ApuestaBase apuestaCara = new ApuestaRojo(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ruleta.jugarRonda(apuestaCara);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    void testJugarSaldoSuficiente() {
        Ruleta ruleta = new Ruleta(repoMock, 1000);
        ApuestaBase apuesta = new ApuestaRojo(100);

        assertDoesNotThrow(() -> {
            ruleta.jugarRonda(apuesta);
        });
    }
}