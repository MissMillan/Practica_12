/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Peliculas;
import Excepciones.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milla
 */
public class AccesoDatosImple implements IAccesoDatos{
//creamos el constructor de nuestra clase
    public AccesoDatosImple() {
     
    }

    //----------------------------------------------------------------------------
    @Override
    public boolean existe(String nombreCatalogo) {
        //creamos un fichero con la clase File para que nos diga si existe
        
        File archivo = new File(nombreCatalogo);
        
       return archivo.exists();
        
    }

    //----------------------------------------------------------------------------
    
    //es posible que nos arroje un error por eso le pondremos el thow leer
    @Override
     public List<Peliculas> Listar(String nombreArchivo)throws LecturaDatosExcep {
       
        //crearemos el fichero en el que vaya a listar
        File archivo = new File(nombreArchivo);
        
        //creamos el objeto pelicula y lo inicializamos con null, por que significa que no hay nada
        Peliculas pelicula = null;
        
        //creamos nuestro array de peliculas donde listara
        List<Peliculas> peliculas = new ArrayList<>();
        try {
            //creamos una variable que leeera el fichero
           BufferedReader entrada = new BufferedReader(new FileReader(archivo));
           
           //creamos la variable que leera nuestro archivo
           var lectura = entrada.readLine();
             while(lectura != null){
                //Añado cada pelicula a mi listado peliculas
                peliculas.add(new Peliculas(lectura));
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
             //cerramos el camino por el que tiene que entrar la variable entrada
           entrada.close();
           
        } catch (Exception e) {
             e.printStackTrace(System.out);
             System.out.println("Error de Lectura Listando las Peliculas");
        }
        //que me devuelva el arraylist de peliculas
        
        return peliculas;
    }

    @Override
    public void escribir(String nombreCatalogo, Peliculas pelicula, boolean anexar)throws EscrituraDatosExcep {
   
        File archivo = new File(nombreCatalogo);
        
        try {
            //necesito crear el boli para escribir en el fichero
            PrintWriter boli = new PrintWriter(new PrintWriter (nombreCatalogo), anexar);
            
            //le digo al poli que me deje escribir el nombre de la pelicula
            boli.print(pelicula.getNombre());
            
            //le digo al boli que tiene que salir cuando ya escriba la pelicula
            boli.close();
            
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
    }
    
    //--------------------------------------------------------------------------------

    @Override
    public String buscar(String nombreCatalogo, String buscar)throws LecturaDatosExcep {
   
        //creamos un nuevo archivo
        var archivo = new File(nombreCatalogo);
        var resultado = "";
        try {
            //entrada es el descriptor de lectura
            //Cuando se da la instrucción "leer" al objeto BufferedReader ,
            //utiliza el FileReader Objeto para leer los datos del archivo.
            var entrada = new BufferedReader(new FileReader(archivo));
            //nos devuelve una linea de nuestro archivo 
            var lectura = entrada.readLine();
            var i = 0;
            //mientras lectura sea disitnto a no encontrar nada
            while(!lectura.equalsIgnoreCase(buscar)){
                i++;
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            resultado = "\nLa pelicula: " + buscar + ", está en la posición "+ i;
          //esto es para salir del fichero
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
        return resultado;
    }
    //---------------------------------------------------------------------------------

    @Override
    public void crear(String nombreCatalogo) throws AccesoDatosExcep {
       
        File archivo = new File(nombreCatalogo);
        
        try {
            //creo el boli que escribira en mi fichero
            PrintWriter boli = new PrintWriter(new FileWriter(archivo));
            
            boli.close();
             System.out.println("Se ha creado el archivo");
        } catch (Exception e) {
            e.printStackTrace(System.out);
          throw new AccesoDatosExcep ("Error al Crear el archivo");
        }
        
    }

    @Override
    public void borrar(String nombreCatalogo) throws AccesoDatosExcep {
        
        var archivo = new File(nombreCatalogo);
        
        try {
            if(archivo.delete());
        } catch (Exception e) {
              e.printStackTrace(System.out);
              System.out.println("Error al borrar el archivo");
        }
        
      
    }


    
}
