/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import java.util.InputMismatchException;
import java.util.Scanner;
import negocio.*;

/**
 *
 * @author milla
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          Menu();
    }
    
    //--------------------------------------------------------------------------
      public static void Menu(){
         var nombreCatalogo = "VideoClub.txt";
           ICatalogoPeliculas catalogo = new CatalogoPeliculaImple();
        
       Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("1. Crear un catalogo de Peliculas");
            System.out.println("2. Agregar una pelicula");
            System.out.println("3. Listar una pelicula");
            System.out.println("4. Buscar una pelicula");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion =Integer.parseInt(sn.nextLine()) ;
 
                switch (opcion) {
                    case 1:
                        System.out.println("\n¡Ha creado un catalogo de peliculas¡\n");
                         catalogo.iniciarCatalogo(nombreCatalogo);
                        break;
                    case 2:
                        System.out.println(" \n¡Escriba la pelicula que quiere agregar¡ ");
                        String palabra = sn.nextLine();
                        catalogo.agregarPelicula(palabra, nombreCatalogo);
                   
                        break;
                    case 3:
                        System.out.println("Las peliculas que tienes agregadas son las siguientes: ");
                       catalogo.listarPelicula(nombreCatalogo);
                        break;
                    case 4:
                         System.out.println(" \n¡Escriba la pelicula que quiere buscar¡ ");
                        String busqueda = sn.nextLine();
                        catalogo.buscarPelicula(nombreCatalogo, busqueda);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
