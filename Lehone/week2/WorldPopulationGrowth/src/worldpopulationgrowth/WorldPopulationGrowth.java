/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldpopulationgrowth;

import java.util.Scanner;

/**
 *
 * @author lehone_hope
 */
public class WorldPopulationGrowth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create scanner object
        Scanner in = new Scanner(System.in);
        long currentPopulation, initialPop;
        double growthRate;
        long increase;
        boolean isDouble = false;
        
        //prompt for current population
        System.out.print("Enter current World population: ");
        initialPop = in.nextLong();
        currentPopulation = initialPop; //at first, current pop = initial pop
        
        //prompt for annual population growth rate
        System.out.print("Enter Annual growth rate: ");
        growthRate = in.nextDouble();
        
        System.out.printf("\n%4s %16s %12s\n", "Year", "Population", "Increase");
                
        //hold the increase in population for a particular year
        for (int i=1; i<=75; i++){
            //compute the addition in population for year i
            increase = (long) (growthRate/100 * currentPopulation);
            
            //add the increase in population to the current pop so as 
            //to have the population for the next year
            currentPopulation += increase;
         
            //display population for year i
            System.out.printf("%4d %,16d %,12d", i, currentPopulation, increase);
            
            //checks if population for each year is doubled and prints "Double Here!"
            //next to the record for that year
            while(isDouble == false){
                if (isDoubled(initialPop, currentPopulation)){
                    System.out.printf("%17s", "<- Doubled Here!");
                    isDouble = true;
                }
                break;
            }//end while
            
            System.out.println();   //print new line after each year's record
        }//end for
        
    }//end main
    
    public static boolean isDoubled(long initPop, long cPop){
        return (cPop >= initPop*2);
    }//end method
}//end driver class WPG