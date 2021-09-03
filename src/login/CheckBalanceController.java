/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Talha Choudhary
 */
public class CheckBalanceController implements Initializable {

    
    @FXML
    private JFXTextField accountno;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField balance;

    @FXML
    private JFXButton search;
    
    String ACCOUNTNO;
    Reader obj=new Reader();
    Writer obj1=new Writer();
    cheker obj2=new cheker();
    

    @FXML
    void handlebuttonaction(ActionEvent event) {
        
        if(event.getSource()==search)
        {
            this.ACCOUNTNO=accountno.getText();
            if(obj1.checkcreditaccount(ACCOUNTNO))
            {
                obj.readdata(ACCOUNTNO);
                name.setText(obj.FIRSTNAME+"  "+obj.LASTNAME);
                balance.setText(obj.AMOUNT);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sorry Account Is Not Present");
                accountno.setText("");
                balance.setText("");
                name.setText("");
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
