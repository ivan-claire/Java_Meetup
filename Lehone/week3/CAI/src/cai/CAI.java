
package cai;
import java.util.*;

/**
 *
 * @author lehone_hope
 * To aid is studying multiplication
 */
public class CAI {

    //create a scanner 
    static Scanner in = new Scanner( System.in );
    
    //create a Random object
    static Random randomNum = new Random();
    
    static int a, b;   //the two positive integers to be multiplied
    static int counter = 1, ans;    //to loop and to hold the current question's answer
    static int response;    //hold user's response to question
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean tryAgain;   //if answer is incorrect, tryagain
        int numOfQuestions; //number of questions to be answered
        
        System.out.println( "\t\tMultiplication\n" );
        
        System.out.print("How many questions: ");   //prompt
        numOfQuestions = in.nextInt();
        
        System.out.println();   //print empty line
        
        //continue asking questions until numOfQuestions
        do {
            //generate two random one digit numbers; 0-9
            a = randomNum.nextInt( 10 );
            b = randomNum.nextInt( 10 );
            
            //ask question until response is correct
            do{
                ans = nextQuestion( a, b );   //prompt
                response = in.nextInt();
                
                tryAgain = checkResp( a, b, response );
            }while( tryAgain == true );
            
        }while ( ++counter <= numOfQuestions );
    }//end main
    
    
    public static int nextQuestion( int a, int b ){
        System.out.print( "How much is " +a+ " times " +b+ " : " );    //prompt
        
        return a * b;
    }//end method nextQuestion
    
    //cheacks if the response is correct
    public static boolean checkResp( int a, int b, int resp ){
        
        if( a * b == resp ){   //reponse is correct
            System.out.println( "Very Good!\n" );
            return false;
        }else{  //if reponse is wrong
            System.out.println( "No! try again.\n" );
            return true;
        }//end if...else...
    
    }//end method checkResp
    
}//end class CAI