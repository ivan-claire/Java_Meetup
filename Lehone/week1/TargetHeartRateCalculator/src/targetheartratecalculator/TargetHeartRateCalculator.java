/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetheartratecalculator;

import java.util.*;

/**
 *
 * @author lehone_hope
 */
public class TargetHeartRateCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        String fName, lName;
        
        //declare a HeartRates object
        HeartRates mine = null;
        boolean successful = false;
        
        //prompt for user's information
        //First Name
        System.out.print("\tHeart Rate Calculator\nEnter First Name: ");
        fName = in.nextLine();
        
        //Last Name
        System.out.print("Enter Last Name: ");
        lName = in.nextLine();
        
        
        //get date of birth and instantise mine object
        while(successful == false){
            try{
                //Date of birth
                System.out.print("Enter date of birth, separate by whitespaces(mm dd yr): ");
                int month = in.nextInt();
                int day = in.nextInt();
                int year = in.nextInt();
                
                //inisialise mine
                mine = new HeartRates(fName, lName, month, day, year);
                successful = true;  
            }catch(IllegalArgumentException exp){
                System.err.println(exp.getMessage());
            }//end try...catch...
        }//end while
        
        
        //display the user's name, age, maxHeartRate, targetHeartRate
        System.out.println("\n" +mine.toString()+ 
                "\nMaximum Heart Rate: " +mine.getMaxHR()+ 
                "bpm\nTarget Heart Rate: " +mine.getTargetHR());
        
    }//end main
    
    
}//end driver class THRC