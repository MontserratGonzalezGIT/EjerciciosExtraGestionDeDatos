/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package examen2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class Examen2Controller implements Initializable {

    @FXML
    private TextField inputFile;
    @FXML
    private Label labelPalabra;
    @FXML
    private Label labelA;
    @FXML
    private Label labelE;
    @FXML
    private Label labelI;
    @FXML
    private Label labelO;
    @FXML
    private Label labelU;
    @FXML
    private TextField inputNewFile;
    @FXML
    private TextField inputPalabra;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }    

    @FXML
    private void actionLeerArchivo(ActionEvent event) throws IOException {
        
        File f = new File(inputFile.getText());
        String contenido = "";
        
        int contadorA = 0;
        int contadorE = 0;
        int contadorI = 0;
        int contadorO = 0;
        int contadorU = 0;
        
        try(FileReader fileReader = new FileReader(f)){
            
        int caracterLeido = 0;
        
        while(caracterLeido!= -1) {
            char caracter = (char) caracterLeido;
            contenido += caracter;
            
            if(caracter == 'a' || caracter == 'A'){
                    contadorA ++;
                }
            if(caracter == 'e' || caracter == 'E'){
                    contadorE ++;
                }
            if(caracter == 'i' || caracter == 'I'){
                    contadorI ++;
                }
            if(caracter == 'o' || caracter == 'O'){
                    contadorO ++;
                }
            if(caracter == 'u' || caracter == 'U'){
                    contadorU ++;
                }
            
            caracterLeido = fileReader.read();
        }
        }catch(IOException ex){
            System.err.println("Error al leer el archivo");
            ex.printStackTrace();

        }
        
        textArea.setText(contenido);
        labelA.setText("A: " + contadorA);
        labelE.setText("E: " + contadorE);
        labelI.setText("I: " + contadorI);
        labelO.setText("O: " + contadorO);
        labelU.setText("U: " + contadorU);
        
    }

    @FXML
    private void actionEscribirArchivo(ActionEvent event) throws IOException {

        File newF = new File(inputNewFile.getText());       
        FileWriter fw = new FileWriter(newF);
        
        
        fw.write(textArea.getText());
        fw.close();
        
    }

    @FXML
    private void actionBotonBuscar(ActionEvent event) {
       
       String contenido = textArea.getText().replaceAll(",", "");
       contenido = contenido.replaceAll("\\.", "");
       
       String[] contenidoSplit = contenido.split(" ");
       int contadorPalabra = 0;
       
       for(String s : contenidoSplit){
           
           if(s.equalsIgnoreCase(inputPalabra.getText())){
               contadorPalabra ++;
           }
           
       }
       
       labelPalabra.setText(inputPalabra.getText() + ": " + contadorPalabra);
        
    }
    
}
