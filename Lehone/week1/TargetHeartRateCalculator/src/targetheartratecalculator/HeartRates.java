package targetheartratecalculator;

import java.util.Date;

/**
 *
 * @author lehone_hope
 */
public class HeartRates {
    private String fName, lName;
    private int day, month, year;
    
    Date today = new Date();
    
    //default constructor
    public HeartRates(){
        fName = "First Name";
        lName = "Last Name";
        day = today.getDay();
        month = today.getMonth();
        year = today.getYear()-100;
    }//end 
    
    //five argument contructor
    //inisialise all fields
    public HeartRates(String fName, String lName, int month, int day, int year){
        this.fName = fName;
        this.lName = lName;
        setMonth(month);
        setDay(day);
        setYear(year);
    }//end five argument constructor
    
    //set first name
    public void setFirstName(String fName){
        this.fName = fName;
    }//end setFirstName
    
    //get first name
    public String getFirstName(){
        return fName;
    }//end getFirstName
    
    //set last name
    public void setLastName(String lName){
        this.lName = lName;
    }//end setlName
    
    //get last name
    public String getLastName(){
        return lName;
    }//end getLastName
    
    //set month of birth
    private void setMonth(int month){
        if (month > 0 && month <= 12)
            this.month = month;
        else
            throw new IllegalArgumentException("Wrong month entered");
        
    }//end setMonth
    
    //set day of Birth
    private void setDay(int day){
        if (day > 0 && day < 31)    //assuming all the months hava atleast 31 days
            this.day = day;
        else
            throw new IllegalArgumentException("Wrong day entered");
    }//end setDay
    
    //set year of birth
    private void setYear( int year){
        if (year>0 && year <= today.getYear()+1900)
            this.year = year;
        else
            throw new IllegalArgumentException("Wrong Year enterd");
    }//end setMonth
    
    //set date of birth
    public void setDOB(int month, int day, int year){
        setMonth(month);
        setDay(day);
        setYear(year);
    }//end setDOB
    
    //get age
    public int getAge(){
        return today.getYear() - this.year + 1900;
    }//end getAge
    
    //get maximum heart rate
    public int getMaxHR(){
        return 220 - getAge();
    }//end getMaxHR
    
    //get target heart range
    public String getTargetHR(){
        double lBound = (double) (50 * getMaxHR()) / 100;
        
        double uBound = (double) (85 * getMaxHR()) / 100;
        
        return String.format("%.1fbpm - %.1fbpm", lBound, uBound);
    }//end getTargetHR
    
    @Override
    public String toString(){
        return String.format("Name: %s %s.\nAge: %dyrs.", fName, lName, getAge());
    }//end toString
}//end class HeartRates