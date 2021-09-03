/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class cheker {
    
    Writer obj=new Writer();
    
    public boolean cheklong(String dep)
    {
        boolean t=true;
        boolean f=false;
        double a;
        try
        {
            a=Long.parseLong(dep);
            return t;
        }
        catch(Exception e)
        {
            return f;
        }
        
    }
    
    public boolean checkbalance(Long amount,String acc)
    {
        boolean t=true;
        boolean f=false;
        Long preamount;
        Reader ob=new Reader();
        ob.readdata(acc);
        preamount=Long.parseLong(ob.AMOUNT);
        long a=preamount-amount;
            if(a<0)               
            {
                return f;
            }
            else 
            {
                return t;
            }   
    }
    
    boolean cheknegativity(String str)
    {
        boolean t=true;
        boolean f=false;
        long a=Long.parseLong(str);
        if(a<0)
        {
            return f;
        }
        else
        {
            return t;
        }
    }
    
    void deletefromaccountfile(String acc)
    {
        FileReader fr=null;
        try {
            fr=new FileReader("AccountNo.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br=new BufferedReader(fr);
        
        FileWriter fw=null;
        try {
            fw=new FileWriter("temp.txt",true);
        } catch (IOException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw=new BufferedWriter(fw);
        String a;
        try {
                while((a=br.readLine())!=null)
                {
                    if(!a.equals(acc))
                    {
                         bw.write(a);
                         bw.newLine();
                    }
                  
                }
        } catch (IOException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.deletefile("AccountNo");
        try {
                br.close();
                bw.close();
        } catch (IOException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        createagain();
    }
    
    void createagain()
    {
        FileReader fr=null;
        try {
            fr=new FileReader("temp.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br=new BufferedReader(fr);
        
        FileWriter fw=null;
        try {
            fw=new FileWriter("AccountNo.txt");
        } catch (IOException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw=new BufferedWriter(fw);
        String a;
        try {
                while((a=br.readLine())!=null)
                {
                         bw.write(a);
                         bw.newLine();
                }
        } catch (IOException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
                br.close();
                bw.close();
        } catch (IOException ex) {
            Logger.getLogger(cheker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    boolean checkequality(String acc1,String acc2)
    {
        boolean t=true;
        boolean f=false;
        if(acc1.equals(acc2))
        {
            return f;
        }
        else
        {
            return t;
        }
    }
    
}
