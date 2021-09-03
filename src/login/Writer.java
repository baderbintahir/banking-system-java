package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Talha Choudhary
 */
public class Writer {
    
       
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
    
    /*************************
          Set Values 
    **************************/
    void setvalue(String ACCOUNTNO,String AMOUNT,String FIRSTNAME,String LASTNAME,String CNIC,String NATIONALITY,String RELIGION,String DATEOFBIRTH,String MOBILENO,String GENDER,String ADRESS){
        
                this.ACCOUNTNO=ACCOUNTNO;
                this.AMOUNT=AMOUNT;
                this.FIRSTNAME=FIRSTNAME;
                this.LASTNAME=LASTNAME;
                this.CNIC=CNIC;
                this.NATIONALITY=NATIONALITY;
                this.RELIGION=RELIGION;
                this.DATEOFBIRTH=DATEOFBIRTH;
                this.MOBILENO=MOBILENO;
                this.GENDER=GENDER;
                this.ADRESS=ADRESS;
            
    }
    
    /*************************
           File Creator
    **************************/        
    void creater(){
        FileWriter fw=null;
        try {
            fw=new FileWriter(ACCOUNTNO+".txt");
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw=new BufferedWriter(fw); 
        try {
            bw.write(ACCOUNTNO+","+AMOUNT+","+FIRSTNAME+","+LASTNAME+","+CNIC+","+NATIONALITY+","+RELIGION+","+DATEOFBIRTH+","+MOBILENO+","+GENDER+","+ADRESS);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    void congraxmessageshow(){
        JOptionPane.showMessageDialog(null,"         Congratulations\n Your Account Is Created");
    }
    void updatedmessageshow(){
        JOptionPane.showMessageDialog(null,"         Congratulations\n Your Account Is Updated");
    }
    void deposit(String newbal){
        JOptionPane.showMessageDialog(null,"       Your Money Is Successfully Deposited  \n              Your New Balance Is = "+newbal);
    }
    void withdraw(String newbal){
        JOptionPane.showMessageDialog(null,"       Your Money Is Successfully Withdrawed  \n              Your New Balance Is = "+newbal);
    }
    void transfer(String newbal){
        JOptionPane.showMessageDialog(null,"       Your Money Is Successfully Transfered  \n              Your New Balance Is = "+newbal);
    }
    
    /*************************
       Account No Adding
    **************************/
    void accountnumbersadding()
    {
        FileWriter fw1=null;
          try {
                    fw1=new FileWriter("AccountNo.txt",true);
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw1=new BufferedWriter(fw1);
        try {  
            bw1.write(ACCOUNTNO);
            bw1.newLine();
            bw1.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*************************
       Check Account No
    **************************/
   boolean checkaccountno(String acc)
    {
        boolean t=true;
        boolean f=false;
        FileReader fr=null;
        try {
            fr=new FileReader("AccountNo.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br=new BufferedReader(fr);
        
        String a=null;
        try {
            while((a=br.readLine())!=null)
            {
                if(acc.equals(a))
                {
                    JOptionPane.showMessageDialog(null,"Account Number Is Already Present\n       Please Write Another");
                    return f;
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    /*************************
       Delete An Account
    **************************/
    void deletefile(String acc)
    {
        File file=new File(acc+".txt");
        file.delete();
    }
    
    /*************************
       Updating Balance
    **************************/
    void setnewbalance(String newbal,String accno)
    {
        Reader obj=new Reader();
        this.AMOUNT=newbal;
        obj.readdata(accno);
        setvalue(obj.ACCOUNTNO,this.AMOUNT,obj.FIRSTNAME,obj.LASTNAME,obj.CNIC,obj.NATIONALITY,obj.RELIGION,obj.DATEOFBIRTH,obj.MOBILENO,obj.GENDER,obj.ADRESS);
        creater();
        
    }
    
    /*************************
       Check Credit Account
    **************************/
    boolean checkcreditaccount(String acc)
    {
        boolean t=true;
        boolean f=false;
        
        FileReader fr=null;
        try {
            fr=new FileReader("AccountNo.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br=new BufferedReader(fr);
        
        String a=null;
        try {
            while((a=br.readLine())!=null)
            {
                if(acc.equals(a))
                {
                    return t;
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
        
    }
    
    /*************************
       Check Empty Fields
    **************************/
    boolean checkvalues(String ACCOUNTNO,String AMOUNT,String FIRSTNAME,String LASTNAME,String CNIC,String NATIONALITY,String RELIGION,String DATEOFBIRTH,String MOBILENO,String GENDER,String ADRESS)
    {
        boolean t=true;
        boolean f=false;

        if((ACCOUNTNO != null && !ACCOUNTNO.isEmpty()) && (AMOUNT != null && !AMOUNT.isEmpty()) && (FIRSTNAME != null && !FIRSTNAME.isEmpty()) && (LASTNAME != null && !LASTNAME.isEmpty()) && (CNIC != null && !CNIC.isEmpty()) && (NATIONALITY != null && !NATIONALITY.isEmpty()) && (RELIGION != null && !RELIGION.isEmpty()) && (DATEOFBIRTH != null && !DATEOFBIRTH.isEmpty()) && (MOBILENO != null && !MOBILENO.isEmpty()) && (GENDER != null && !GENDER.isEmpty()) && (ADRESS != null && !ADRESS.isEmpty()))
        {
            return t;
        }
        else
        {
            return f;
        }
        
    }
    
    /*******************************
       Check Empty Deposit Field
    *******************************/
    boolean checkfields(String AMOUNT)
    {
        boolean t=true;
        boolean f=false;

        if((AMOUNT != null && !AMOUNT.isEmpty()))
        {
            return t;
        }
        else
        {
            return f;
        }
        
    }
    
    
    
}
