package edu.upc.dsa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.HashMap;

@Path("etakemon")
public class PruebaRest {

    EtakemonManagerImpl a=EtakemonManagerImpl.getInstance();

    @GET
    @Path("{Username}")
    @Produces(MediaType.TEXT_PLAIN)
    public HashMap getLista(@PathParam("Username") String username){return a.listadoUsuarios();}

    @GET
    @Path("")
}
