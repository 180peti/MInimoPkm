package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public interface EtakemonManager {

    HashMap<String,Usuarios> listadoUsuarios();

    boolean añadirUsuario(Usuarios user);

    boolean modificarUsuario(String nombre,HashMap<String,Integer> parametros);

    Usuarios informacionUsuario(String nombre);

    List<Objeto> objetosUsuario(String nombre);

    boolean añadirObjecto(String nombre,Objeto objeto);



}
