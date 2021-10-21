/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

//este es el pquete de la clase peliculas
import Dominio.Peliculas;
import Excepciones.*;
import java.util.List;


/**
 *
 * @author milla
 */
public interface IAccesoDatos {
    
    //este metodo devuleve un boolean si el archivo existe
    boolean existe (String nombreCatalogo)throws AccesoDatosExcep;
    
    //un arrayList de la clase peliculas
    List <Peliculas> Listar(String nombreArchivo)throws LecturaDatosExcep;
    
    //este metodo nos sirve para escribir la pelicula
    void escribir (String nombreCatalogo, Peliculas pelicula, boolean anexar)throws EscrituraDatosExcep;
    
    //funcion que nos devolvera un mensaje para buscar la pelicula
    String buscar(String nombreCatalogo, String buscar)throws LecturaDatosExcep;
    
     //Crear el archivo
    void crear(String nombreCatalogo)throws AccesoDatosExcep;
    
     
    void borrar(String nombreCatalogo)throws AccesoDatosExcep;
}
