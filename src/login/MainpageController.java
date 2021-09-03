/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Talha Choudhary
 */
public class MainpageController implements Initializable {
    
    @FXML
    private AnchorPane trans;
     
    @FXML
    private JFXButton createaccount;
    
    @FXML
    private AnchorPane area;
    
    @FXML
    private JFXButton modify;
    
    @FXML
    private JFXButton deposit;

    @FXML
    private JFXButton withdraw;

    @FXML
    private JFXButton transfer;
    
    @FXML
    private JFXButton delete;
    
    @FXML
    private JFXButton about;
    
    @FXML
    private JFXButton logout;
    
    @FXML
    private JFXButton checkbalance;
       
    String ACCOUNTNO=null;
    
    @FXML
    void exitbutton(MouseEvent event) {
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
    void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }

    @FXML
    void handlebuttonaction(ActionEvent event) throws IOException {
        
        if(event.getSource()==createaccount)
        {
            Parent p=FXMLLoader.load(getClass().getResource("createaccount.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==modify)
        {
            Parent p=FXMLLoader.load(getClass().getResource("Profile.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==deposit)
        {
            Parent p=FXMLLoader.load(getClass().getResource("Deposit.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==withdraw)
        {
            Parent p=FXMLLoader.load(getClass().getResource("Withdraw.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==transfer)
        {
            Parent p=FXMLLoader.load(getClass().getResource("Transfer.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==delete)
        {
            Parent p=FXMLLoader.load(getClass().getResource("Delete.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==about)
        {
            Parent p=FXMLLoader.load(getClass().getResource("About.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==checkbalance)
        {
            Parent p=FXMLLoader.load(getClass().getResource("CheckBalance.fxml"));
            area.getChildren().removeAll();
            area.getChildren().setAll(p);
            
        }
        if(event.getSource()==logout)
        {
                Parent parent1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene1 = new Scene(parent1);
                Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage1.hide();
                stage1.setScene(scene1);
                stage1.show();
            
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
