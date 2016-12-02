/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumbers;

/**
 *
 * @author lehone_hope
 */
public class Complex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create two ComplexNumber objects z1 and z2
        ComplexNumber z1 = new ComplexNumber(2, 4);
        ComplexNumber z2 = new ComplexNumber(0.5, 3);
        
        System.out.println("z1 : " +z1);
        System.out.println("z2 : " +z2);
        //display the sum and difference of z1 and z2 resp.
        System.out.println("\nAddition\nz1 - z2 = " +z1.add(z2));
        System.out.println("\nSubtraction\nz1 + z2 = " +z1.subtract(z2));
    }//end main
    
}//end class Complex
