package edu.upc.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuarios {

    String nombre;
    HashMap<String,Integer> parametros;
    ArrayList<Objeto> inventario=new ArrayList<Objeto>();;

    public Usuarios(String nombre) {
        this.nombre = nombre;
        this.parametros = new HashMap<String, Integer>();
        this.parametros.put("Salud",10);
        this.parametros.put("Ataque",10);
        this.parametros.put("Defensa",10);
        this.parametros.put("Velocidad",10);
    }

    public String getNombre() {
        return nombre;
    }

    public void setParametros(HashMap<String, Integer> parametros) {
        this.parametros = parametros;
    }

    public List<Objeto> getInventario() {
        return inventario;
    }
    public boolean añadirObjeto(Objeto o){
        return inventario.add(o);
    }
}
