/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Talha Choudhary
 */
public class WithdrawController implements Initializable {

 
    @FXML
    private JFXTextField accountno;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField balance;

    @FXML
    private JFXTextField withdraw;

    @FXML
    private JFXTextField newbalance;

    @FXML
    private Button search;
    
    @FXML
    private Button withdrawbutton;
    
    String ACCOUNTNO;
    long AMOUNT1;
    long NEWBALANCE;
    
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
                balance.setText(obj.AMOUNT);
                name.setText(obj.FIRSTNAME+"  "+obj.LASTNAME);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sorry Account Is Not Present");
                accountno.setText("");
                balance.setText("");
                name.setText("");
            }
        }
          if(event.getSource()==withdrawbutton)
        {
            if(obj1.checkfields(withdraw.getText()))
            {
                if(obj2.cheklong(withdraw.getText()))
                {
                    AMOUNT1=Long.parseLong(withdraw.getText());
                   if(obj2.cheknegativity(withdraw.getText()))
                   {        
                        if(obj2.checkbalance(AMOUNT1,ACCOUNTNO))
                        {
                            obj.readdata(ACCOUNTNO);
                            NEWBALANCE=(Long.parseLong(obj.AMOUNT))-AMOUNT1;
                            String str=String.valueOf(NEWBALANCE);
                            obj1.setnewbalance(str,ACCOUNTNO);
                            obj1.withdraw(str);
                            accountno.setText("");
                            name.setText("");
                            balance.setText("");
                            withdraw.setText("");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You Don't Have Enough Balance");
                            withdraw.setText("");
                        }
                       
                   }
                   else
                   {
                        JOptionPane.showMessageDialog(null,"Balance Must Be A Positive Integer");
                        withdraw.setText("");
                   }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Fill The Withdraw Field With Integer Value");
                    withdraw.setText("");
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Fill The Withdraw Field");
            }
            
        }

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
