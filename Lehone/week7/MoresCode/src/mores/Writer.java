/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mores;

import java.util.Formatter;
import javax.swing.JOptionPane;

/**
 *
 * @author lehone_hope
 * writes to a file
 */

public class Writer {
    public Formatter output;
    public String path;
    
    public Writer(String path){
        this.path = path;
    }//end Writer's one argument constructor
    
    public void openFile(){
        try{
            output = new Formatter(path);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }//end try ... catch ...
    }//end method openFile()
    
    public void write(String text){
        if (text != null)
            output.format("%s", text);
    }//end method
    
    public void closeFile(){
        output.close();
    }
    
}//end Writer class
