/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seccion4;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alfas
 */
public class modelLibreria {
    
    Connection conn;
    
    String MySQLURL = "jdbc:mysql://localhost:3306/libreria";
    String databaseUserName = "2DAM";
    String databasePassword = "2DAM2022";

   public Connection connectToDB() {
      String resultado = "";
      Connection conn = null;
      try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(this.MySQLURL, this.databaseUserName, this.databasePassword);
            return this.conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }
   
   public void cerrarConn() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
   public String leerTabla(){
       String datos = "";
       try(
         PreparedStatement stmt = this.connectToDB().prepareStatement("SELECT id,titulo,autor,anyo,editorial,numPagines FROM libro");
         ResultSet rs = stmt.executeQuery();
       ) {		
           
         while(rs.next()){
            datos = datos + "ID: " + rs.getInt("id") + ", Titulo: " + rs.getString("titulo") + ", Autor: " + rs.getString("autor") + ", Año: " + rs.getInt("anyo") + ", Editorial: " + rs.getString("editorial") + ", Numero de Paginas: " + rs.getInt("numPagines") + "\n\r"; 
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
       
       return datos;
   }
   
   public Libro leerFila(int id){
       Libro l = new Libro();
       
       try(
         PreparedStatement stmt = this.connectToDB().prepareStatement("SELECT id,titulo,autor,anyo,editorial,numPagines FROM libro WHERE id=" +id);
         ResultSet rs = stmt.executeQuery();
       ) {		
         while(rs.next()){
           
           l.setID(rs.getInt("id"));
           l.setTitulo(rs.getString("titulo"));
           l.setAutor(rs.getString("autor"));
           l.setAnyo(rs.getInt("anyo"));
           l.setEditorial(rs.getString("editorial"));
           l.setNumPagines(rs.getInt("numPagines"));
           
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
       
       return l;
   }
   
   public boolean addLibro (Libro l){
       
        try {
            PreparedStatement stmt = this.connectToDB().prepareStatement("INSERT INTO libro(titulo,autor,anyo,editorial,numPagines) VALUES(?, ?, ?, ?, ?)");
            
            
            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setInt(3, l.getAnyo());
            stmt.setString(4, l.getEditorial());
            stmt.setInt(5, l.getNumPagines());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            return false;
            
        } finally {
            this.cerrarConn();
        }
    }
   
   public boolean quemarLibro (int id) {
        try {
            PreparedStatement stmt = this.connectToDB().prepareStatement("DELETE FROM libro where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.cerrarConn();
        }
    }
   
   public boolean actualizarLibro(Libro l) {
        try {
            
            PreparedStatement stmt = this.connectToDB().prepareStatement("UPDATE libro set titulo=?,autor=?,anyo=?,editorial=?,numPagines=? WHERE id=?");

            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setInt(3, l.getAnyo());
            stmt.setString(4, l.getEditorial());
            stmt.setInt(5, l.getNumPagines());
            stmt.setInt(6, l.getID());
            stmt.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.cerrarConn();
        }
    }

}
