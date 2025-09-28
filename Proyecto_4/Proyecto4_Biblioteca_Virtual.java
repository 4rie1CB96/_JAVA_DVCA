/*
 *  Modelar una base de datos con Libros, Autores y Usuarios.
    Cada libro tiene un autor, un usuario puede pedir varios libros.
    Crear un menú en consola en Java para:
    - Registrar libro.
    - Prestar libro.
    - Devolver libro.
    - Ver lista de préstamos activos.
 */


package Proyecto_4;

import java.time.LocalDate;

class Libro {
    private String titulo;
    private Autor autor;
    private LocalDate fechaPublicacion;
    private double precioLibro;
    
    public Libro(String titulo, Autor autor, LocalDate fechaPublicacion, double precioLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.precioLibro = precioLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", fechaPublicacion=" + fechaPublicacion
                + ", precioLibro=" + precioLibro + "]";
    }

    
}

class Autor {
    
}

class Usuario {

}

public class Proyecto4_Biblioteca_Virtual {

    public static void main(String[] args) {
        
    }
}