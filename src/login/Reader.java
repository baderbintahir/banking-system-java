/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Talha Choudhary
 */
public class Reader {
    
    public String ACCOUNTNO;
    public String AMOUNT;
    public String FIRSTNAME;
    public String LASTNAME;
    public String CNIC;
    public String NATIONALITY;
    public String RELIGION;
    public String DATEOFBIRTH;
    public String MOBILENO;
    public String GENDER;
    public String ADRESS;
    
    void readdata(String acc){
            FileReader fr=null;
        try {
            fr=new FileReader(acc+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br=new BufferedReader(fr);
        String str=null;
        String[] temp;
        try {
                str=br.readLine();
                temp=str.split(",");
                this.ACCOUNTNO=temp[0];
                this.AMOUNT=temp[1];
                this.FIRSTNAME=temp[2];
                this.LASTNAME=temp[3];
                this.CNIC=temp[4];
                this.NATIONALITY=temp[5];
                this.RELIGION=temp[6];
                this.DATEOFBIRTH=temp[7];
                this.MOBILENO=temp[8];
                this.GENDER=temp[9];
                this.ADRESS=temp[10]; 
                br.close();
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
