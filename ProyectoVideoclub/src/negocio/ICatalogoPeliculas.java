/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author milla
 */
public interface ICatalogoPeliculas {
    //creamos los metodos de los que heredaran nuestra clase catalogoImple
    
    //este metodo nos devolvera el nombre de la pelicula y le pasaremos 
    //de parametro el nombre del catalogo
    void agregarPelicula(String nombrePelicula, String nombreCatalogo);
    
    //este metodo nos mostrara las peliculas que tengamos y de parametro 
    //le pasaremos nuestro catalgoo de pelicula
    void listarPelicula(String nombreCatalogo);
    
    //este metodo le psaremos por parametro nuestro catalogo para que busque 
    //la pelicula , y ademas "buscar" , que sera la pelicula que deseamos buscar
    void buscarPelicula(String nombreCatalogo, String buscar);
    
    //este metodo creara o inicializar nuestro catalogo
    //para ello le pasaremos por parametro nuestro catatlogo
    void iniciarCatalogo(String nombreCatalogo);
}
