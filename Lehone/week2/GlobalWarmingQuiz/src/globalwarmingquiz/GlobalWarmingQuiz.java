/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globalwarmingquiz;

import java.util.*;

/**
 *
 * @author lehone_hope
 */
public class GlobalWarmingQuiz {
    static Scanner in = new Scanner(System.in);
    
    static final int[] answers = {3, 2, 1, 1, 4};   //the correct quize responses
    static int score = 0;   //hold the total score after the quiz

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int response;   //to hold the response of the questions
        
        System.out.println("\tGlobal Warming Quiz");
        
        //administer the quit
        for (int i=0; i<5; i++){
            System.out.print( nextQuestion(i) );    //displays next question
            System.out.print( "Response: " );   //prompt
            response = in.nextInt();
            
            //increment score if response is correct
            if (response == answers[i])
                score++;
        }//end for
        
        //display remark based on score
        remark( score );
        
    }//end main
    
    //method returns the string rep. of each of the various questions
    public static String nextQuestion(int i){
        String toReturn = null; //return variable
        
        //based on the question number, i, switch assigns question to toReturn
        switch (i){
            case 0: //Question 1
                toReturn = String.format("\nAre Global temperatures rising now?\n"
                        + "1. Yes   2. No   3. It is difficult to tell   4. Maybe\n");
                break;
                
            case 1: //Question 2
                toReturn = String.format("\nWhich of the following is not "
                        + "a greenhouse gas\n"
                        + "1.Carbondioxide    2. Oxygen   3. Methane   4. Nitrous oxides\n");
                break;
                
            case 2: //Question 3
                toReturn = String.format("\nWhat is the best thing to do, in "
                        + "order to reduce global warming?\n"
                        + "1. Use renewable energy   2. Buy a bicycle   \n"
                        + "3. Burn up all non-biodegradables   "
                        + "4. Wait and see what happens\n");
                break;
                
            case 3: //Question 4
                toReturn = String.format("\nWhich of the following is not found "
                        + "in the atmosphere?\n"
                        + "1.Fish    2. Water vapour   3. Carbondioxide   4. Oxygen\n");
                break;
                
            case 4: //Question 5
                toReturn = String.format("\nWho/what is responsible for ozone layer depletion\n"
                        + "1. Man   2. Technology   3. Nature   4. CFCs\n");
                break;
            
        }//end switch
        
        return toReturn;
    }//end method
    
    //displays the remark based on the score obtained
    public static void remark(int score){
        
        switch( score ){
            case 5: //when score is 5
                System.out.println("\nTotal Score: " +score+ "\nExcellent!");
                break;
                
            case 4: //when score is 4
                System.out.println("\nTotal Score: " +score+ "\nVery Good!");
                break;
                
            default:    //when score is <= 3
                System.out.println("\nTotal Score: " +score+ 
                        "\nTime to brush up your knowledge on Global Warming\n"
                        + "visit: http://www.who.com\n"
                        + "       http://www.unicef.com\n"
                        + "       http://www.lehone.com");
                break;   
        }//end switch
    }//end method remark
    
}//end class