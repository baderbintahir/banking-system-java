package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;


public class DeleteController implements Initializable {

  
    @FXML
    private JFXTextField accountno;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField cnic;

    @FXML
    private JFXButton deletebutton;

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
                cnic.setText(obj.CNIC);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sorry Account Is Not Present");
                accountno.setText("");
            }
            
        }
        if(event.getSource()==deletebutton)
        {
            String str="AccountNo";
            JOptionPane.showMessageDialog(null,"Are You Sure You Want To Delete The Account");
            obj1.deletefile(ACCOUNTNO);
            obj2.deletefromaccountfile(ACCOUNTNO);
            JOptionPane.showMessageDialog(null,"Your Account Is Successfully Deleted");
            accountno.setText("");
            name.setText("");
            cnic.setText("");

        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
