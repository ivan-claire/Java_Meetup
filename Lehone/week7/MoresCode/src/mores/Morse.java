/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mores;

/**
 *<h2>Morse Code</h2>
 * 
 * <p>This class implements the Morse Coding scheme<br>
 * The Morse code assigns a series of dots(.) and dashes(-) to each 
 * letter of the alphabet, each digit, and a few special characters (e.g., period,
 * comma, colon, semicolon etc). </p>
 * 
 * <p> Separation between characters of a word is represented by a space or the 
 * absence of a dot or dash e.g. HOPE == .... --- .--. .
 *                                       H    O   P    E                 
 * Separation between words is represented by three spaces 
 * e.g. Hello World ! == .... . .-.. .-.. ---   .-- --- .-. .-.. -..   -.-.--. 
 * </p>                            
 * 
 * @author lehone_hope
 */
public class Morse {
     //hold the Mores characters from A-Z, 0-9 and special characters.-@ resp
    private String[] morseChSet = {
        /*Alphaberts starting from A*/".-", "-...", "-.-.", "-..", ".", "..-.", 
        "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
        "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", /* to Z*/
        /*Numbers, stating from 0*/"-----", ".----", "..---", "...--", "....-",  
        ".....", "-....", "--...", "---..", "----."/* to 9*/, 
        /*Some Special chars: . , / ? ( up to */".-.-.-", "--..--", "..--..", ".----.", 
        "-.-.--", "-..-.", "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-",
        ".-.-.", "-....-", "..--.-", ".-..-.", "...-..-", ".--.-.", /*...@*/
        "\n", "\t", "`"};  
    
    //hold the character set 0-1Aa-Zz
    private char[] englishChSet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '0','1', '2', '3','4', '5', '6', '7', '8', '9', '.', ',', '?',
        '\'' , '!', '/', '(', ')', '&', ':', ';', '=', '+', '-', '_', '"', '$', '@',
        '\n', '\t', '`'};   
    
    //english and morse phrases where on is to be converted to the other
    private String engPhrase, morPhrase;
    
    public Morse(){
        setEngPh("");
        setMorPh("");
    }//default constructor
    
    public Morse(String ph){
        setEngPh(ph);
    }//one argument constructor
    
    //set the engPhrase's value
    public void setEngPh(String ph){
        engPhrase = ph;
    }
    
    //set morPhrase's value 
    public void setMorPh(String mor){
        morPhrase = mor;
    }
    
    public String[] getMorseChSet(){
        return morseChSet;
    }//end method
    
    /**
     * Method receives a character, converts it and returns its Morse equivalent
     * @param ch is an Arabic numeral(e.g a,x)
     * @return A String which is the Morse Equivalent of the parameter e.g "..-."
     */
    public String toMorseCh(char ch){
        return morseChSet[getIndex(ch)];
    }//end toMorseCh
    
    /**
     *Gets a word and converts the entire word to its Morse Equivalent 
     * @param ch An array of characters(the word) to be converted
     * @return The Morse Equivalent of the word as a String array and not a String
     */
    public String[] toMorseChrs(char[] ch){
        String[] mchrs = new String[ch.length];   //hold the converted character
        
        for (int i=0; i<mchrs.length; i++)
            mchrs[i] = toMorseCh(ch[i]);
        
        return mchrs;
    }//end method
    
    /**
     *Joins all the converted Morse letters into one word
     * This is done by adding a space between each Morse Character
     * @param letters, an array of all the characters of a particular word 
     * which have already been converted to Morse Equivalent
     * @return A String which represents the word in Morse code
     */
    public String appendMorseChrs(String[] letters){
        String mWord = "";
        
        for(int i=0; i<letters.length; i++){
            mWord += letters[i];
            if (i < letters.length-1)
                mWord += " ";   //add a space at the end of each Morse Character
        }//end for
        
        return mWord;
    }//end method
    
    /**
     *Takes a list of words from a phrase and converts each of the words to their
     * respective Morse equivalent and then return them in another array
     * @param tokens are the different words of the English phrase
     * @return An array of the Morse Equivalent of each of these tokens 
     */
    public String[] toMorsePhrase(String[] tokens){
        //hold the Morse Equivalent of the characters of token(word) being processed
        char[] ch;  
        //hold the converted tokens(word)
        String[] conv = new String[tokens.length];
        
        //convert each token to its Morse Equivalent
        for (int i=0; i<conv.length; i++){
            ch = new char[tokens[i].length()];
            
            tokens[i].getChars(0, tokens[i].length(), ch, 0);
            conv[i] = appendMorseChrs(toMorseChrs(ch));
        }
        return conv;
    }//end method 
    
    /**
     * A Morse Word is a series of dots and dashes where each letter is separated 
     * from the next by a space.
     * Joins all the converted Morse words(tokens of the phrase) into one Morse Phrase
     * This is done by adding three space between each Morse Word
     * @param mWords, a list of the converted tokens(words)
     * @return A String which represents the entire phrase in Morse
     */
    public String appendMorWords(String[] mWords){
        String mPhr = "";
        for(int i=0; i<mWords.length; i++){
            mPhr += mWords[i];
            if (i < mWords.length-1)
                mPhr += "   ";  //add three white spaces at the end of each word
        }
        return mPhr;
    }//end append words
    
    /**
     * Method takes an English phrase and converts it to its Morse Equivalent
     * The method splits the Phrase where there is a single space, into different 
     * words(tokens).
     * The Tokens are then converted to obtain their respective Morse Equivalent which
     * are then joint together to form the Morse Equivalent of the English phrase
     * @param phrase-The English Phrase
     * @return the Morse Equivalent of the English Phrase
     */
    public String getMorseEquiv(String phrase){
        return appendMorWords(toMorsePhrase(phrase.split(" ")));
    }//end method 
    
    /**
     * Takes in a character and return the index of that character with respect to
     * the character set listed from A to Z, 0 to 9 and some special characters 
     * like . , / ? @ etc
     * @param ch, character whose index is to be known
     * @return an Integer, representing the index of the character
     */
    public int getIndex(char ch){
        switch(ch){
            case 'A':
            case 'a':
                return 0;
            
            case 'B':
            case 'b':
                return 1;
                
            case 'C':
            case 'c':
                return 2;
                
            case 'D':
            case 'd':
                return 3;
                
            case 'E':
            case 'e':
                return 4;
                
            case 'F':
            case 'f':
                return 5;
                
            case 'G':
            case 'g':
                return 6;
                
            case 'H':
            case 'h':
                return 7;
                
            case 'I':
            case 'i':
                return 8;
                
            case 'J':
            case 'j':
                return 9;
                
            case 'K':
            case 'k':
                return 10;
                
            case 'L':
            case 'l':
                return 11;
                
            case 'M':
            case 'm':
                return 12;
                
            case 'N':
            case 'n':
                return 13;
                
            case 'O':
            case 'o':
                return 14;
                
            case 'P':
            case 'p':
                return 15;
                
            case 'Q':
            case 'q':
                return 16;
                
            case 'R':
            case 'r':
                return 17;
                
            case 'S':
            case 's':
                return 18;
                
            case 'T':
            case 't':
                return 19;
                
            case 'U':
            case 'u':
                return 20;
                
            case 'V':
            case 'v':
                return 21;
                
            case 'W':
            case 'w':
                return 22;
                
            case 'X':
            case 'x':
                return 23;
                
            case 'Y':
            case 'y':
                return 24;
                
            case 'Z':
            case 'z':
                return 25;
            case '0':
                return 26;
            
            case '1':
                return 27;
            
            case '2':
                return 28;
            
            case '3':
                return 29;
            
            case '4':
                return 30;
            
            case '5':
                return 31;
            
            case '6':
                return 32;
            
            case '7':
                return 33;
            
            case '8':
                return 34;
            
            case '9':
                return 35;
            
            case '.':
                return 36;
            
            case ',':
                return 37;
            
            case '?':
                return 38;
            
            case '\'':
                return 39;
            
            case '!':
                return 40;
            
            case '/':
                return 41;
            
            case '(':
                return 42;
            
            case ')':
                return 43;
            
            case '&':
                return 44;
            
            case ':':
                return 45;
            
            case ';':
                return 46;
            
            case '=':
                return 47;
            
            case '+':
                return 48;
            
            case '-':
                return 49;
            
            case '_':
                return 50;
            
            case '"':
                return 51;
            
            case '$':
                return 52;
            
            case '@':
                return 53;
                
            case '\n':
                return 54;
                
            case '\t':
                
                return 55;
        }//end switch
        
        return 56;  //incase a character out of the charset is enterd
    }//end getIndex
    
    
                /*Methods to convert a morse phrase to english*/

    /**
     * Gets the English equivalent of any Morse Character mCh
     * @param mCh is the Morse Character to be converted
     * @return An English Char which is the Equivalent of mCh
     */
    public char toEnglishCh(String mCh){
        return englishChSet[getIndex(mCh)];
    }//end toEnglishCh
    
    /**
     * Gets the English Equivalent of the Characters of a Morse Word.
     * A Morse Word is an array of Strings where each String represent a Morse Character
     * @param mWord, an array of Strings representing each Morse Character respectively
     * @return The English Equivalent of the word as a Char array and not a String
     */
    public char[] toEnglishChrs(String[] mWord){
        char[] chrs = new char[mWord.length];
        
        for(int i=0; i<chrs.length; i++)
            chrs[i] = toEnglishCh(mWord[i]);
        
        return chrs;
    }//end toEnglishChrs
    
    /**
     * AppendEngChrs receives an array of English Characters and joins them together,
     * forming an English Word.
     * @param chrs, the Char array to be appended
     * @return a String representation of the char array
     */
    public String appendEngChrs(char[] chrs){
        return new String(chrs);   
    }//end appendEngChrs
    
    /**
     * toEnglishPhrase converts all the respective tokens(words) of a Morse Prase
     * into their respective English Equivalent.
     * A Morse Phrase is a String where each word is separated from the next by three
     * spaces.
     * @param tokens, the respective Morse Words of the Morse Phrase
     * @return a String array which is the respective English Equivalent of each 
     * token
     */
    public String[] toEnglishPhrase(String[] tokens){
        
        String[] conv = new String[tokens.length];
        
        for (int i=0; i<conv.length; i++){
            conv[i] = appendEngChrs(toEnglishChrs(tokens[i].split(" ")));
            
        }
        
        return conv;
    }//end toEnglishPhrase
    
    /**
     * A String array of English words are appended to form an English Phrase
     * @param words, a array of English Words
     * @return The English phrase derived from words
     */
    public String appendEngWords(String[] words){
        String wd = "";
        
        for (String s : words){
            wd += s;
            wd += " ";  //adds a space after every words
        }
        
        return wd;
    }//end appendEngWords
    
    /**
     * Returns the English Equivalent of a Morse Phrase i.e. a Phrase written using
     * the Morse Coding Scheme.
     * The Method Splits the Morse Phrase into tokens(Morse Words) where there is
     * the presence of three spaces.
     * The tokens are then converted to their English Equivalent and then appended
     * to form its English Equivalent.
     * @param s, Morse Phrase to be converted.
     * @return a String, representing the English Equivalent of the Morse Phrase
     */
    public String getEnglishEquiv(String s){
        return appendEngWords(toEnglishPhrase(s.split("   ")));
    }//end getEnglishEquiv
    
    /**
     * Takes in a Morse character and return the index of that character with respect to
     * the character set listed from ".-" to "--..", "-----" to "----." and
     * some special characters like ".-.-.-" "--..--" "-..-." "..--.." ".--.-." etc
     * @param s, Morse character whose index is to be known
     * @return an Integer, representing the index of the Morse character s
     */
    public int getIndex(String s){
        switch(s){
            case ".-":
                return 0;
            
            case "-...":
                return 1;
                
            case "-.-.":
                return 2;
                
            case "-..":
                return 3;
                
            case ".":
                return 4;
                
            case "..-.":
                return 5;
                
            case "--.":
                return 6;
                
            case "....":
                return 7;
                
            case "..":
                return 8;
                
            case ".---":
                return 9;
                
            case "-.-":
                return 10;
                
            case ".-..":
                return 11;
                
            case "--":
                return 12;
                
            case "-.":
                return 13;
                
            case "---":
                return 14;
                
            case ".--.":
                return 15;
                
            case "--.-":
                return 16;
                
            case ".-.":
                return 17;
                
            case "...":
                return 18;
                
            case "-":
                return 19;
                
            case "..-":
                return 20;
                
            case "...-":
                return 21;
                
            case ".--":
                return 22;
                
            case "-..-":
                return 23;
                
            case "-.--":
                return 24;
                
            case "--..":
                return 25;
                
            case "-----":
                return 26;
            
            case ".----":
                return 27;
            
            case "..---":
                return 28;
            
            case "...--":
                return 29;
            
            case "....-":
                return 30;
            
            case ".....":
                return 31;
            
            case "-....":
                return 32;
            
            case "--...":
                return 33;
            
            case "---..":
                return 34;
            
            case "----.":
                return 35;
                
            case ".-.-.-":
                return 36;
                
            case "--..--":
                return 37;
                
            case "..--..":
                return 38;
                
            case ".----.":
                return 39;
                
            case "-.-.--":
                return 40;
                
            case "-..-.":
                return 41;
                
            case "-.--.":
                return 42;
                
            case "-.--.-":
                return 43;
                
            case ".-...":
                return 44;
                
            case "---...":
                return 45;
                
            case "-.-.-.":
                return 46;
                
            case "-...-":
                return 47;
                
            case ".-.-.":
                return 48;
                
            case "-....-":
                return 49;
                
            case "..--.-":
                return 50;
                
            case ".-..-.":
                return 51;
                
            case "...-..-":
                return 51;
                
            case "..-..-":
                return 52;
                
            case ".--.-.":
                return 53;
                
            case "\n":
                return 54;
                
            case "\t":
                return 55;
        }//end switch
        
        return 56;  //incase a character out of the charset is enterd
    }//end switch
}//end class
