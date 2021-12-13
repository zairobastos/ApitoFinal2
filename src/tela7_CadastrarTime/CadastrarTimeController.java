/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela.pkg07.cadastrartime;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

/**
 *
 * @author eroti
 */
public class CadastrarTimeController{
    @FXML
    private Button btn1;
    
    @FXML
    private ListView lista;
            
    public void Button1Action (ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile !=null){
            lista.getItems().add(seletedFile.getName());
        }else{
            System.out.println("Arquivo não é válido!");
        }
    }
    
}
