
import static org.junit.Assert.*;

public class EtakemonManagerImplTest {
    EtakemonManagerImpl a;

    @org.junit.Before
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

    @org.junit.After
    public void tearDown() throws Exception {
        a.getInstance().borrar();
        //assertNull(a.listadoUsuarios()); COMO COMPRUEBO QUE SE HAN LIBERADO LOS RECURSOS???
    }

    @org.junit.Test
    public void añadirUsuario() throws Exception {
        Usuarios u=new Usuarios("Pepe");
        assertFalse(a.añadirUsuario(u));
        u=new Usuarios("Juan");
        assertTrue(a.añadirUsuario(u));
        int cantidad=a.listadoUsuarios().size();
        assertEquals(4,cantidad);
    }

    @org.junit.Test
    public void añadirObjecto() throws Exception {
        Objeto o=new Objeto("Escudo","Armadura",0,2);
        assertTrue(a.añadirObjecto("Pepe",o));
        assertEquals(2,a.objetosUsuario("Pepe").size());
        assertFalse(a.añadirObjecto("Juanjo",o));
    }

    /*@org.junit.Test
    public void getInstance() throws Exception {

    }

    @org.junit.Test
    public void borrar() throws Exception {
        a.getInstance().borrar();
        assertNull(a);
    }

    @org.junit.Test
    public void listadoUsuarios() throws Exception {
        assertEquals(3,a.listadoUsuarios().size());
    }*/


    /*
    @org.junit.Test
    public void modificarUsuario() throws Exception {
        HashMap<String,Integer> parametros= new HashMap<String, Integer>();
        parametros.put("Salud",20);
        parametros.put("Ataque",15);
        parametros.put("Defensa",12);
        parametros.put("Velocidad",10);
        assertTrue(a.modificarUsuario("Pepe",parametros));
        assertFalse(a.modificarUsuario("Juanjo",parametros));
    }

    @org.junit.Test
    public void informacionUsuario() throws Exception {
        assertNull("No existe",a.informacionUsuario("Juanjo"));
        assertNotNull("Existe",a.informacionUsuario("Pepe"));
    }

    @org.junit.Test
    public void objetosUsuario() throws Exception {
        assertNull(a.objetosUsuario("Juanjo"));
        assertEquals(1,a.objetosUsuario("Pepe").size());
    }*/



}