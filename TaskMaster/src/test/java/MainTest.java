import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void buscarUsuarioExistente() {

        Usuario u = new Usuario(
                1,
                "Sergio",
                "sergio@gmail.com",
                "1234"
        );

        Main.usuarios.add(u);

        Usuario resultado = Main.buscarUsuario(1);

        assertNotNull(resultado);

        assertEquals("Sergio", resultado.nombre);
    }

    @Test
    void buscarUsuarioInexistente() {

        Usuario resultado = Main.buscarUsuario(99);

        assertNull(resultado);
    }
}