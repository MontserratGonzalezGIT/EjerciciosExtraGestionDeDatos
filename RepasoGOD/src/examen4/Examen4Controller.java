/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package examen4;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class Examen4Controller implements Initializable {

    @FXML
    private TextField idText;
    @FXML
    private TextField ciudadText;
    @FXML
    private TextField codigoText;
    @FXML
    private TextField distritoText;
    @FXML
    private TextField poblacionText;

    /**
     * Initializes the controller class.
     */
    DBUtil db;
    ResultSet rs;
    
    String idTemp;
    String ciudadTemp;
    String codigoTemp;
    String distritoTemp;
    String poblacionTemp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        db = new DBUtil();
        Statement stmt;
        try {
            stmt = db.connectToDB().createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM city");;
            if(rs.first()){
                
                idText.setText(rs.getString("ID"));
                ciudadText.setText(rs.getString("Name"));
                codigoText.setText(rs.getString("CountryCode"));
                distritoText.setText(rs.getString("District"));
                poblacionText.setText(rs.getString("Population"));
                
                idTemp = idText.getText();
                ciudadTemp = ciudadText.getText();
                codigoTemp = codigoText.getText();
                distritoTemp = distritoText.getText();
                poblacionTemp = poblacionText.getText();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Examen4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    @FXML
    private void accionButtonConf(ActionEvent event) {
    }

    @FXML
    private void accionButtonAtras(ActionEvent event) throws SQLException {
        
        rs.previous();
        if(!rs.isBeforeFirst()){
            
                           if(idText.getText().equals("") && !rs.isLast()){
                               rs.next();
                               rs.deleteRow();
                           }

                           if(!ciudadTemp.equals(ciudadText.getText()) || !codigoTemp.equals(codigoText.getText()) || !distritoTemp.equals(distritoText.getText()) || !poblacionTemp.equals(poblacionText.getText())){
                            rs.updateString("Name", ciudadText.getText());
                            rs.updateString("CountryCode", codigoText.getText());
                            rs.updateString("District", distritoText.getText());
                            rs.updateString("Population", poblacionText.getText());
                            rs.updateRow();
                           }
                           
                           idText.setText(rs.getString("ID"));
                           ciudadText.setText(rs.getString("Name"));
                           codigoText.setText(rs.getString("CountryCode"));
                           distritoText.setText(rs.getString("District"));
                           poblacionText.setText(rs.getString("Population"));
                        

                    
                            
                    
            }
            
            idTemp = idText.getText();
            ciudadTemp = ciudadText.getText();
            codigoTemp = codigoText.getText();
            distritoTemp = distritoText.getText();
            poblacionTemp = poblacionText.getText();
            
        
        
    }

    @FXML
    private void accionButtonAdelante(ActionEvent event) throws SQLException {
        
        
            rs.next();
            if(rs.isAfterLast()){

                if(!ciudadText.getText().equals("") && !codigoText.getText().equals("") && !distritoText.getText().equals("") && !poblacionText.getText().equals("") && ciudadTemp.equals("") && codigoTemp.equals("") && distritoTemp.equals("") && poblacionTemp.equals("")){
                    rs.moveToInsertRow();
                    rs.updateString("Name",ciudadText.getText());
                    rs.updateString("CountryCode",codigoText.getText());
                    rs.updateString("District",distritoText.getText());
                    rs.updateString("Population",poblacionText.getText());
                    rs.insertRow();

                }else{
                    idText.setText("");
                    ciudadText.setText("");
                    codigoText.setText("");
                    distritoText.setText("");
                    poblacionText.setText("");
                }

            }else{
                    if(idText.getText().equals("")){
                        rs.previous();
                        rs.deleteRow();
                        rs.next();
                    }
                    
                   if(!ciudadTemp.equals(ciudadText.getText()) || !codigoTemp.equals(codigoText.getText()) || !distritoTemp.equals(distritoText.getText()) || !poblacionTemp.equals(poblacionText.getText())){
                    rs.updateString("Name", ciudadText.getText());
                    rs.updateString("CountryCode", codigoText.getText());
                    rs.updateString("District", distritoText.getText());
                    rs.updateString("Population", poblacionText.getText());
                    rs.updateRow();
                   }

                   idText.setText(rs.getString("ID"));
                   ciudadText.setText(rs.getString("Name"));
                   codigoText.setText(rs.getString("CountryCode"));
                   distritoText.setText(rs.getString("District"));
                   poblacionText.setText(rs.getString("Population"));
                    
            }
            
        


            idTemp = idText.getText();
            ciudadTemp = ciudadText.getText();
            codigoTemp = codigoText.getText();
            distritoTemp = distritoText.getText();
            poblacionTemp = poblacionText.getText();
        
        
    }

    @FXML
    private void accionButtonRaw(ActionEvent event) {
    }
    
}
