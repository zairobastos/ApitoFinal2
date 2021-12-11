/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import dao.VerificaLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author RonaldoMatos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField senhaPass;

    VerificaLogin verifica = new VerificaLogin();
    boolean retorno;

    @FXML
    private void botaoEntrar(ActionEvent event) {
        retorno = verifica.verificaLogin(emailTxt.getText(), senhaPass.getText());

        if(retorno == true){
            //TODO: inicializar outra tela
            //fecha();
            JOptionPane.showMessageDialog(null, "Login verificado.");

        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        senhaPass.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) ->{
            try {
                if(event.getCode() == KeyCode.ENTER){
                    retorno = verifica.verificaLogin(emailTxt.getText(), senhaPass.getText());

                    if(retorno == true){
                        //TODO: inicializar outra tela
                        //fecha();
                        JOptionPane.showMessageDialog(null, "Login verificado.");

                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        });
        
    }  
    
    /**
     * Método para fechar a tela atual
     */
    public void fecha(){
        ApitoFinal.getStage().close();
    }
    
}
