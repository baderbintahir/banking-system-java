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


public class ProfileController implements Initializable {

    @FXML
    private JFXTextField accountno;

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField cnic;

    @FXML
    private JFXTextField religion;

    @FXML
    private JFXTextField mobileno;

    @FXML
    private JFXTextField balance;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField nationality;

    @FXML
    private JFXTextField gender;

    @FXML
    private JFXTextField adress;

    @FXML
    private JFXTextField DOB;
    
    @FXML
    private JFXButton edit;
    
    @FXML
    private JFXButton save;
    
    @FXML
    private JFXButton search;

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
    
    Reader obj=new Reader();
    Writer obj1=new Writer();
    
    @FXML
    void handlebuttonaction(ActionEvent event) {
        
        if(event.getSource()==search)
        {
            this.ACCOUNTNO=accountno.getText();
            if(obj1.checkcreditaccount(ACCOUNTNO))
            {
                obj.readdata(ACCOUNTNO);
                balance.setText(obj.AMOUNT);
                firstname.setText(obj.FIRSTNAME);
                lastname.setText(obj.LASTNAME);
                cnic.setText(obj.CNIC);
                nationality.setText(obj.NATIONALITY);
                religion.setText(obj.RELIGION);
                DOB.setText(obj.DATEOFBIRTH);
                mobileno.setText(obj.MOBILENO);
                gender.setText(obj.GENDER);
                adress.setText(obj.ADRESS);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sorry Account Is Not Present");
                accountno.setText("");
                balance.setText("");
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
            
        }
        
        if(event.getSource()==edit)
        {
            accountno.setEditable(false);
            firstname.setEditable(true);
            lastname.setEditable(true);
            cnic.setEditable(true);
            nationality.setEditable(true);
            religion.setEditable(true);
            DOB.setEditable(true);
            mobileno.setEditable(true);
            gender.setEditable(true);
            adress.setEditable(true);
        }
        if(event.getSource()==save)
        {
            ACCOUNTNO=accountno.getText();
            AMOUNT=balance.getText();
            FIRSTNAME=firstname.getText();
            LASTNAME=lastname.getText();
            CNIC=cnic.getText();
            NATIONALITY=nationality.getText();
            RELIGION=religion.getText();
            DATEOFBIRTH=DOB.getText();
            MOBILENO=mobileno.getText();
            GENDER=gender.getText();
            ADRESS=adress.getText();
            
            if(obj1.checkvalues(ACCOUNTNO, AMOUNT, FIRSTNAME, LASTNAME, CNIC, NATIONALITY, RELIGION, DATEOFBIRTH, MOBILENO, GENDER, ADRESS))
            {
                 obj1.setvalue(ACCOUNTNO, AMOUNT, FIRSTNAME, LASTNAME, CNIC, NATIONALITY, RELIGION, DATEOFBIRTH, MOBILENO, GENDER, ADRESS);
                 obj1.creater();
                 obj1.updatedmessageshow();
                 accountno.setEditable(true);
                 firstname.setEditable(false);
                 lastname.setEditable(false);
                 cnic.setEditable(false);
                 nationality.setEditable(false);
                 religion.setEditable(false);
                 DOB.setEditable(false);
                 mobileno.setEditable(false);
                 gender.setEditable(false);
                 adress.setEditable(false);
                 accountno.setText("");
                 balance.setText("");
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
                JOptionPane.showMessageDialog(null,"Please Fill All The Data Carefully");
            }
            
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
