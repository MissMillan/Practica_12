/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Datos.AccesoDatosImple;
import Datos.IAccesoDatos;
import Dominio.Peliculas;
import Excepciones.AccesoDatosExcep;
import Excepciones.EscrituraDatosExcep;
import Excepciones.LecturaDatosExcep;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milla
 */
public class CatalogoPeliculaImple implements ICatalogoPeliculas{
    
    //creo una variable de la interfaz de acceso a datos, que me permitira acceder a sus metodos
    //crear, listar, buscar, inciarcatalogo.
 private final IAccesoDatos datos;
 
 //-------------------------------------------------------------------------------
 
 //me declaro el constructor



    public CatalogoPeliculaImple() {
        //inicializo la variable con el constructor de acceso a datos que podra acceder a sus metodos
        this.datos = new AccesoDatosImple();
    }
 
  //-------------------------------------------------------------------------------
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreCatalogo) {
     try {
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.escribir(nombreCatalogo,new Peliculas(nombrePelicula), true);
            }else {
                System.out.println("Catalogo no inicializado");
            }
        } catch (EscrituraDatosExcep ex){
            System.out.println("Error al Agregar Pelicula");
            ex.printStackTrace(System.out);
        } catch (AccesoDatosExcep ex) {
            System.out.println("Error al Agregar Pelicula");
            ex.printStackTrace();
        }
        
    }

     //-------------------------------------------------------------------------------
    @Override
    public void listarPelicula(String nombreCatalogo) {
    List<Peliculas> peliculas = new ArrayList<>();
        try {
            peliculas = this.datos.Listar(nombreCatalogo);
            peliculas.forEach(pelicula -> {
            System.out.println("\n"+pelicula.getNombre());
        });
        } catch(LecturaDatosExcep ex){
            System.out.println("Error leyendo catálogo");
            ex.printStackTrace(System.out);
        }
    }

     //-------------------------------------------------------------------------------
    @Override
    public void buscarPelicula(String nombreCatalogo, String buscar) {
              //tenemos que instanciar el archivo
        var archivo = new File(nombreCatalogo);
        
        //llama a buscar de la capa de acceso a datos
        try {
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        } catch (LecturaDatosExcep ex) {
            ex.printStackTrace();
            System.out.println("Error al buscar el archivo");
        }
        
    }

     //-------------------------------------------------------------------------------
    @Override
    public void iniciarCatalogo(String nombreCatalogo) {
              var archivo = nombreCatalogo;
              try {
            this.datos.crear(archivo);
        } catch (AccesoDatosExcep ex) {
             ex.printStackTrace();
            System.out.println("Error al Iniciar el Archivo");
        }
    }
    
}
