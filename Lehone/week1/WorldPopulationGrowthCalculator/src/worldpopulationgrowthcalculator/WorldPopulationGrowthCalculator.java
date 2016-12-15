/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldpopulationgrowthcalculator;

import java.util.*;

/**
 *
 * @author lehone_hope
 */
public class WorldPopulationGrowthCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create scanner object
        Scanner in = new Scanner(System.in);
        long currentPopulation;
        double growthRate;
        long increase;
        
        //prompt for current population
        System.out.print("Enter current World population: ");
        currentPopulation = in.nextLong();
        
        //prompt for annual population growth rate
        System.out.print("Enter Annual growth rate: ");
        growthRate = in.nextDouble();
        
        System.out.println();   //print new line
        
           //hold the increase in population for a particular year
        for (int i=1; i<=5; i++){
            //compute the addition in population for year i
            increase = (long) (growthRate/100 * currentPopulation);
            
            //add the increase in population to the current pop so as 
            //to have the population for the next year
            currentPopulation += increase;
         
            //display population for year i
            System.out.printf("Year %2d, Population: %d\n", i, currentPopulation);
        }//end for
        
    }//end main method
    
}//end driver class WPGC
