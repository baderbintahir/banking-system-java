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


public class DepositController implements Initializable{

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField balance;

    @FXML
    private JFXTextField deposit;

    @FXML
    private JFXTextField newbalance;

    @FXML
    private JFXTextField accountno;

    @FXML
    private JFXButton depositbutton;

    @FXML
    private JFXButton search;
    
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
        if(event.getSource()==depositbutton)
        {
            if(obj1.checkfields(deposit.getText()))
            {
                
                if(obj2.cheklong(deposit.getText()))
                {
                    if(obj2.cheknegativity(deposit.getText()))
                    {
                        AMOUNT1=Long.parseLong(deposit.getText());
                        obj.readdata(ACCOUNTNO);
                        NEWBALANCE=(Long.parseLong(obj.AMOUNT))+AMOUNT1;
                        String str=String.valueOf(NEWBALANCE);
                        obj1.setnewbalance(str,ACCOUNTNO);
                        obj1.deposit(str);
                        accountno.setText("");
                        name.setText("");
                        balance.setText("");
                        deposit.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Balance Must Be A Positive Number");
                        deposit.setText("");
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Fill The Deposit Field With Integer Value");
                    deposit.setText("");
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Fill The Deposit Field");
            }
            
        }

    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
