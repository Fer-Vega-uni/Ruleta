package controladores;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControladorSesionTest {
    private ControladorSesion controladorSesion;

    @BeforeEach
    void setUp() {
        controladorSesion = new ControladorSesion();
        controladorSesion.registrarUsuario("fer","111","f");
    }

    @Test
    void testLoginUsuarioNoRegistrado() {
        boolean resultado = controladorSesion.iniciarSesion("usuario_fantasma", "1234");
        assertFalse(resultado, "Debe rechazar login de usuario que no existe");
        assertFalse(controladorSesion.hayUsuario(), "No debe haber usuario en sesión");
    }

    @Test
    void testRegistroUsernameNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            controladorSesion.registrarUsuario("Juan", "1234", null);
        }, "Debe lanzar excepción si el username es null");
    }
}