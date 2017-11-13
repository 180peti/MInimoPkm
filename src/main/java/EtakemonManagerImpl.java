
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class EtakemonManagerImpl implements EtakemonManager {

    HashMap<String,Usuarios> users;
    static EtakemonManagerImpl instance;
    final static Logger log=Logger.getLogger(EtakemonManagerImpl.class.getName());

    public EtakemonManagerImpl()
    {
        users=new HashMap<String,Usuarios>();
        org.apache.log4j.BasicConfigurator.configure();
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
            log.info("Usuario añadido con el nombre "+user.getNombre());
            users.put(user.getNombre(),user);
            hecho=true;
        }else{log.info("el usuario "+user.getNombre()+" ya esta en la lista");}
        return hecho;
    }

    public boolean modificarUsuario(String nombre, HashMap<String,Integer> parametros) {
        boolean hecho=false;
        if (users.containsKey(nombre))
        {
            log.info("Parametros del usuario "+nombre+" cambiados");
            users.get(nombre).setParametros(parametros);
            hecho=true;
        }else{log.info("el usuario "+nombre+" no existe");}
        return hecho;
    }

    public Usuarios informacionUsuario(String nombre) {
        Usuarios u=null;
        if (users.containsKey(nombre))
        {

            u=users.get(nombre);
        }else{log.info("el usuario "+nombre+" no existe");}
        return u;
    }

    public List<Objeto> objetosUsuario(String nombre) {
        if (users.containsKey(nombre)){
            log.info("Lista de objetos del usuario "+nombre);
        return users.get(nombre).getInventario();
        }
        else{return null;}
    }

    public boolean añadirObjecto(String nombre,Objeto objeto) {
        boolean hecho=false;
        if (users.containsKey(nombre))
        {
            log.info("Añadido el objeto "+objeto.nombre+" al usuario "+nombre);
            hecho=users.get(nombre).añadirObjeto(objeto);
        }
        return hecho;
    }
}
