/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mores;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author lehone_hope
 */
public class Reader {

    private Scanner in;
    private String path;
    
    public Reader(String path){
        this.path = path;
    }
    
    public void openFile(){
        try{
            in = new Scanner( new File(path));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, 
                    "Error", "An error occured while trying to read file!", 
                    JOptionPane.ERROR_MESSAGE);
        }//end try...catch...
    }//end method
    
    public String read(){
        String content = "";
        
        while (in.hasNext()){
            content += in.nextLine();
            content += '\n';
        }
        
        return content;
    }
    
    public void closeFile(){
            in.close();
    }
}
