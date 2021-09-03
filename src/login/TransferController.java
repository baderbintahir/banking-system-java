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
public class TransferController implements Initializable {

    @FXML
    private JFXTextField accountno;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField balance;

    @FXML
    private JFXTextField creditaccount;

    @FXML
    private JFXTextField transfer;
    
    @FXML
    private Button transferbutton;

    @FXML
    private Button search1;
    
    String ACCOUNTNO;
    String CREDITACCOUNT;
    
    long AMOUNT1;
    long AMOUNT2;
    long NEWBALANCE1;
    long NEWBALANCE2;
    
    Reader obj=new Reader();
    Writer obj1=new Writer();
    cheker obj2=new cheker();


    @FXML
    void handlebuttonaction(ActionEvent event) {
        
        if(event.getSource()==search1)
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
        if(event.getSource()==transferbutton)
        {
            if(obj2.checkequality((accountno.getText()),(creditaccount.getText())))
            {
                CREDITACCOUNT=creditaccount.getText();
                
                if(obj1.checkcreditaccount(CREDITACCOUNT))
                {       
                    if((obj1.checkfields(transfer.getText()))&&(obj1.checkfields(creditaccount.getText())))
                    {
                        if(obj2.cheklong(transfer.getText()))
                        {
                            AMOUNT1=Long.parseLong(transfer.getText());
                            
                            if(obj2.cheknegativity(transfer.getText()))
                            {
                                if(obj2.checkbalance(AMOUNT1,ACCOUNTNO))
                                {
                                    obj.readdata(ACCOUNTNO);
                                    NEWBALANCE1=(Long.parseLong(obj.AMOUNT))-AMOUNT1;
                                    String str1=String.valueOf(NEWBALANCE1);
                                    obj1.setnewbalance(str1,ACCOUNTNO);
                                    AMOUNT2=Long.parseLong(transfer.getText());
                                    obj.readdata(CREDITACCOUNT);
                                    NEWBALANCE2=(Long.parseLong(obj.AMOUNT))+AMOUNT2;
                                    String str2=String.valueOf(NEWBALANCE2);
                                    obj1.setnewbalance(str2,CREDITACCOUNT);
                                    obj1.transfer(str1);
                                    accountno.setText("");
                                    name.setText("");
                                    balance.setText("");
                                    creditaccount.setText("");
                                    transfer.setText("");

                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"You Don't Have Enough Balance");
                                    transfer.setText("");
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Balance Must Be A Positive Number");
                                transfer.setText("");
                            }

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please Fill The Transfer Field With Integer Value");
                            transfer.setText("");
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Please Fill The Transfer Field");
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Sorry Account Is Not Present");
                    creditaccount.setText("");
                    transfer.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Data Transfer To Same Accoun No Is Not Allowed");
                creditaccount.setText("");
            }
        }

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
