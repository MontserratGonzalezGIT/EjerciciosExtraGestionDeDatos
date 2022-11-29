/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seccion4;

/**
 *
 * @author alfas
 */
public class Libro {
    
    private int ID;
    private String titulo;
    private String autor;
    private int anyo;
    private String editorial;
    private int numPagines;

    public int getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyo() {
        return anyo;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getNumPagines() {
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

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setNumPagines(int numPagines) {
        this.numPagines = numPagines;
    }
    
}
