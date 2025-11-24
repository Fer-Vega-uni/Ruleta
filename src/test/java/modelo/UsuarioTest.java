package modelo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @BeforeEach
    void setUp() {
        Usuario user= new Usuario();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("A")
    void testvalidarCredenciales() {

    }


    @Test
    @DisplayName("Prueba de deposito: saldo actual(5000) + saldo nuevo (400)")
    void testdepositar() {
        Usuario user= new Usuario();
        user.depositar(400);
        Assertions.assertEquals(5400, user.getSaldo());

    }

    @Test
    @DisplayName("Mish")
    void testactualizarSaldo() {

    }

}