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
public class CreateaccountController implements Initializable {
    
    @FXML
    private JFXButton create;
    
    @FXML
    private JFXTextField amount;

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField cnic;

    @FXML
    private JFXTextField religion;

    @FXML
    private JFXTextField adress;

    @FXML
    private JFXTextField mobileno;

    @FXML
    private JFXTextField nationality;

    @FXML
    private JFXTextField gender;

    @FXML
    private JFXTextField DOB;
    
    @FXML
    private JFXTextField accountno;
    
    String ACCOUNTNO;
    String AMOUNT;
    String FIRSTNAME;
    String LASTNAME;
    String CNIC;
    String NATIONALITY;
    String RELIGION;
    String DATEOFBIRTH;
    String MOBILENO;
    String GENDER;
    String ADRESS;
    
    Writer obj=new Writer();
    cheker obj2=new cheker();

    @FXML
    void handlebuttonaction(ActionEvent event){
        
        
        
        if(event.getSource()==create)
        {
            ACCOUNTNO=accountno.getText();
            
            if(obj.checkaccountno(ACCOUNTNO))
            {
                    AMOUNT=amount.getText();
                    FIRSTNAME=firstname.getText();
                    LASTNAME=lastname.getText();
                    CNIC=cnic.getText();
                    NATIONALITY=nationality.getText();
                    RELIGION=religion.getText();
                    DATEOFBIRTH=DOB.getText();
                    MOBILENO=mobileno.getText();
                    GENDER=gender.getText();
                    ADRESS=adress.getText();
                    
                    if(obj.checkvalues(ACCOUNTNO, AMOUNT, FIRSTNAME, LASTNAME, CNIC, NATIONALITY, RELIGION, DATEOFBIRTH, MOBILENO, GENDER, ADRESS))
                    {
                        if((obj2.cheklong(accountno.getText()))&&(obj2.cheklong(amount.getText())))
                        {
                            if((obj2.cheknegativity(accountno.getText())) && (obj2.cheknegativity(amount.getText())))
                            {
                                obj.setvalue(ACCOUNTNO, AMOUNT, FIRSTNAME, LASTNAME, CNIC, NATIONALITY, RELIGION, DATEOFBIRTH, MOBILENO, GENDER, ADRESS);
                                obj.accountnumbersadding();
                                obj.creater();
                                obj.congraxmessageshow();
                                accountno.setText("");
                                amount.setText("");
                                firstname.setText("");
                                lastname.setText("");
                                cnic.setText("");
                                nationality.setText("");
                                religion.setText("");
                                DOB.setText("");
                                mobileno.setText("");
                                gender.setText("");
                                adress.setText("");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Please Fill The Fields With Only Positive Values");
                                accountno.setText("");
                                amount.setText("");
                            }
                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please Fill The Fields With Only Integer Values");
                            accountno.setText("");
                            amount.setText("");
                        }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Please Fill All The Data Carefully");
                    }
                    
            }
            else
            {
                accountno.setText("");
            }
         
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
