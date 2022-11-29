/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seccion3;

/**
 *
 * @author alfas
 */
public class Libro {
    
    private int ID;
    private String titulo;
    private String autor;
    private String anyo;
    private String editorial;
    private String numPagines;

    public int getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnyo() {
        return anyo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getNumPagines() {
        return numPagines;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setNumPagines(String numPagines) {
        this.numPagines = numPagines;
    }
    
}
