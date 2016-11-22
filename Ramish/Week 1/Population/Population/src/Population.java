
import java.util.Scanner;//importing scanner class
/**
 * 
 * @author ramish benoit
 *
 */
public class Population { 
	public static void main(String[] args){
		 Scanner input=new Scanner(System.in);
		 
		 float currentPop;//variable that holds current population
		 float growthRate;
		 float increaseRate;
		 int t;
		 
		 System.out.println("enter the growth rate in percentage\n");
		 
		 	growthRate= input.nextFloat();
		 	
		 	growthRate =growthRate/100;
	
		 	System.out.println("enter current population\n");
		 	currentPop=input.nextFloat();
		 	System.out.println("YEAR		POPULATION		INCREASERATE");
		 			t=1;
		 			while(t<=75)
		 			{
		
		 				increaseRate=currentPop*growthRate;
		 				currentPop+=increaseRate;
		
		 				System.out.printf("%d		%.2f		%.2f\n",t,currentPop,increaseRate);
		 				t++;
		}
	}//end of main method

}//end of class pop
