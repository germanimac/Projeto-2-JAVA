/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("controle")
public class control {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of control
     */
    public control() {
    }

    /**
     * Retrieves representation of an instance of controle.control
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() throws IOException, Exception {
        write("0");
        return readFileAsString("Direction.txt");
        
    }
        

    /**
     * PUT method for updating or creating an instance of testws
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    @GET
    @Produces("application/json")
    @Path("cima")
    public String getcima(){
        write("1");
        return "cima";
    }
    @GET
    @Produces("application/json")
    @Path("esquerda")
    public String getesquerda(){
        write("3");
        return "esquerda";
    }
    @GET
    @Produces("application/json")
    @Path("direita")
    public String getdireita(){
        write("2");
        return "direita";
    }
    @GET
    @Produces("application/json")
    @Path("baixo")
    public String getbaixo(){
        write("4");
        return "baixo";
    }
    
     private static void write(String data) {
        try {
            Files.write(Paths.get("../d.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
 
  public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 

}
