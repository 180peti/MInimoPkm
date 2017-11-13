import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EtakemonManagerImplTest {
    EtakemonManagerImpl a;
    @Before
    public void setUp() throws Exception {
        a=EtakemonManagerImpl.getInstance();
        Usuarios u=new Usuarios("Pepe");
        a.añadirUsuario(u);
        Objeto o=new Objeto("Espada","Cuerpo a cuerpo",2,4);
        a.añadirObjecto("Pepe",o);
        u=new Usuarios("Jordi");
        a.añadirUsuario(u);
        u=new Usuarios("Ruben");
        a.añadirUsuario(u);
    }

    @After
    public void tearDown() throws Exception {
        a.getInstance().borrar();
        //assertNull(a.listadoUsuarios()); COMO COMPRUEBO QUE SE HAN LIBERADO LOS RECURSOS???
    }

    @Test
    public void añadirUsuario() throws Exception {
        Usuarios u=new Usuarios("Pepe");
        assertFalse(a.añadirUsuario(u));
        u=new Usuarios("Juan");
        assertTrue(a.añadirUsuario(u));
        int cantidad=a.listadoUsuarios().size();
        assertEquals(4,cantidad);
    }

    @Test
    public void añadirObjecto() throws Exception {
        Objeto o=new Objeto("Escudo","Armadura",0,2);
        assertTrue(a.añadirObjecto("Pepe",o));
        assertEquals(2,a.objetosUsuario("Pepe").size());
        assertFalse(a.añadirObjecto("Juanjo",o));
    }
}