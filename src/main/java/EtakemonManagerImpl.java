
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EtakemonManagerImpl implements EtakemonManager {

    HashMap<String,Usuarios> users;
    static EtakemonManagerImpl instance;

    public EtakemonManagerImpl()
    {
        users=new HashMap<String,Usuarios>();
    }

    public static EtakemonManagerImpl getInstance() {
        if (instance==null)
        {
            instance= new EtakemonManagerImpl();
        }
        return instance;
    }
    public void borrar(){ //?
        this.instance=null;
    }

    private void ordenarUsuarios(){
        //No perder tiempo
    }

    public HashMap<String,Usuarios> listadoUsuarios() {
        ordenarUsuarios();
        return users;
    }

    public boolean añadirUsuario(Usuarios user) {
        boolean hecho=false;
        if (!users.containsKey(user.getNombre())){
            users.put(user.getNombre(),user);
            hecho=true;
        }
        return hecho;
    }

    public boolean modificarUsuario(String nombre, HashMap<String,Integer> parametros) {
        boolean hecho=false;
        if (users.containsKey(nombre))
        {
            users.get(nombre).setParametros(parametros);
            hecho=true;
        }
        return hecho;
    }

    public Usuarios informacionUsuario(String nombre) {
        Usuarios u=null;
        if (users.containsKey(nombre))
        {
            u=users.get(nombre);
        }
        return u;
    }

    public List<Objeto> objetosUsuario(String nombre) {
        if (users.containsKey(nombre)){
        return users.get(nombre).getInventario();
        }
        else{return null;}
    }

    public boolean añadirObjecto(String nombre,Objeto objeto) {
        boolean hecho=false;
        if (users.containsKey(nombre))
        {
            hecho=users.get(nombre).añadirObjeto(objeto);
        }
        return hecho;
    }
}
