/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author Talha Choudhary
 */
public class FXMLDocumentController implements Initializable {
 
    @FXML
    private JFXButton login;

    @FXML
    private JFXTextField username;
    
    @FXML
    private JFXPasswordField password;
    
    Writer obj=new Writer();
    
    @FXML
    void closeapp(MouseEvent event) {
        System.exit(0);
    }
    
    double x;
    double y;
    @FXML
    void draged(MouseEvent event) {
        Node node=(Node)event.getSource();
        Stage stage=(Stage)node.getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }
    
    @FXML
    void presed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==login)
        {
            if((obj.checkfields(username.getText())) && (obj.checkfields(password.getText())))
            {
                    String s1="Admin";
                    String s2="admin";

                    if((username.getText().equals(s1)) && (password.getText().equals(s2)))
                    {

                        Parent parent1 = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
                        Scene scene1 = new Scene(parent1);
                        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage1.hide();
                        stage1.setScene(scene1);
                        stage1.show();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Wrong User Name Or Password\n           Please Try Again");
                        username.setText("");
                        password.setText("");     
                    }

            }
            else
            {
                JOptionPane.showMessageDialog(null,"     Please Fill All Data");
            }
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
