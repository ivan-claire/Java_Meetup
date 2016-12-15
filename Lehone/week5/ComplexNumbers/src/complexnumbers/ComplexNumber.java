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

public class ComplexNumber {
    private double real;    //real part of the complex number
    private double img;     //imaginary part of the complex number
    private final double i = Math.sqrt(-1);
    
    public ComplexNumber(){
        real = 1.0;
        img = 1.0;
    }//end default constructor
    
    public ComplexNumber(double real, double img){
        setReal(real);
        setImg(img);
    }//end two argument constructor
    
    //set the real part of the complex number
    public void setReal(double real){
        this.real = real;
    }
    
    //get the real part of the complex number
    public double getReal(){
        return this.real;
    }
    
    //set the imaginary part of the complex number
    public void setImg(double img){
        this.img = img;
    }
    
    //get the imaginary part of the complex number
    public double getImg(){
        return this.img;
    }
    
    //add this comlex number and another complex number
    public ComplexNumber add(ComplexNumber z1){
        ComplexNumber z = new ComplexNumber();
        
        z.setImg(z1.getImg() + this.getImg());
        z.setReal(z1.getReal() + this.getReal());
        
        return z;
    }//end method add
    
    //subtract another complex number from this complex number
    public ComplexNumber subtract(ComplexNumber z1){
        ComplexNumber z = new ComplexNumber();
        
        z.setImg(this.getImg() - z1.getImg());
        z.setReal(this.getReal() - z1.getReal());
        
        return z;
    }//end method add
    
    
    @Override
    public String toString(){
        return String.format("(%.1f, %.1fi)", this.getReal(), this.getImg());
    }
    
}//end class ComplexNumber