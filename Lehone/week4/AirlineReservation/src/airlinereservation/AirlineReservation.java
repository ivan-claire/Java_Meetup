/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinereservation;

import java.util.Scanner;

/**
 *
 * @author lehone_hope
 */
public class AirlineReservation {

    static int nextFCSeat = 0; //the next first class seat to be assigned (0-4);
    static int nextESeat = 5;  //the next economic seat to be assigned (5-9);
    static int classNum;    //1 for first class and 2 for economy class
    
    //seats on the plane to be assigned
    static boolean[] seats = new boolean[10];
    
    //create Scanner object
    static Scanner in = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //initialise seats[]
        initialiseSeats();
        System.out.println("\tAirline Reservation");
        do{
            //get plane class
            System.out.print("\nPlease type 1 for FIRST CLASS or 2 for ECONOMY: ");
            classNum = in.nextInt();
            //in.reset();

            if(classNum == 1)
                assignFirstClass();
            else
                if(classNum == 2)
                    assignEconomy();
                
        }while(nextFCSeat + nextESeat < 15);
        
        System.out.println("\tAll seats occupied!");
        
    }//end main
    
    
                         /*Methods*/
    
    //initialise seats to false .i.e. they have not yet beign booked
    public static void initialiseSeats(){
        for (boolean seat: seats)
            seat = false;
    }//end method
    
    
    
    /**
     * @param classNum; 1 for first class and 2 for economic
     * @return false if no seat is available and true if a seat is available
     */
    public static boolean isThereSpace(int classNum){
        
        boolean toRet = false;  //we assume that at first all the seats are booked
        
        if (classNum == 1){ 
            //check if seat is available in first class
            for (int i=nextFCSeat; i<seats.length/2; i++)
                if(seats[i] == false){
                    toRet = true;
                    break;
                }//end if
        }else{
            //if seat is available in economy class
            for (int i=nextESeat; i<seats.length; i++)
                if(seats[i] == false){
                    toRet = true;
                    break;
                }//end if
        }//end if..else..
        
        return toRet;  
    }//end method
    
    public static void assignFirstClass(){
        if(isThereSpace(1) == true){
            seats[nextFCSeat++] = true;
            //display boarding pass
            System.out.println("\nSeat Number: " +nextFCSeat+ 
                    ".\nSeat Class: First Class.\n\n");
        }else{
            if(isThereSpace(2) == true){
                System.out.print("\nFirst Class full!\nWould you like a seat in the "
                        + "Economy class, 1:Yes or 0:No: ");
                int resp = in.nextInt();
                
                if(resp == 1){
                    assignEconomy();
                }else
                    System.out.println("Next Flight leaves in 3hours");
            }else
                System.out.println("No seats available");
        }//end if...else...
    }//end method
    
    public static void assignEconomy(){
        if(isThereSpace(2) == true){
            seats[nextESeat++] = true;
            //display boarding pass
            System.out.println("\nSeat Number: " +nextESeat+ 
                    ".\nSeat Class: Economy.\n\n");
        }else{
            if(isThereSpace(1) == true){
                System.out.print("Economy full!\nWould you like a seat in the "
                        + "First class, 1:Yes or 0:No: ");
                int resp = in.nextInt();
                
                if(resp == 1){
                    assignFirstClass();
                }else
                    System.out.println("Next Flight leaves in 3hours");
            }else
                System.out.println("No seats available");
        }//end if...else...
    }//end method
    
}//end class AirlineReservation