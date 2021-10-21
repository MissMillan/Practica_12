/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author milla
 */
public class Peliculas {
    //atributos
    
    private String nombre;
    
    //----------------------------------------------------

    public Peliculas(String nombre) {
          this();
        this.nombre = nombre;
    }

    public Peliculas() {
    }
    
    //--------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Peliculas: " + "nombre de la Pelicula" + nombre + '}';
    }
    
    
}
