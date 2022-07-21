import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * Object that stores the words in ArrayLists.
 * 
 * @author Michael Zou
 * @version March 24, 2018
 */
public class WordStorage extends Actor
{
    //boolean variable that checks if the word has been typed or not
    private boolean wordDone = true;

    //int variable that stores the number of words solved
    private int numWords = 0;
    
    //ArrayLists that stores the words
    private static ArrayList<String> simpleWords = new ArrayList<String>();
    private static ArrayList<String> mediumWords = new ArrayList<String>();
    private static ArrayList<String> hardWords = new ArrayList<String>();

    /**
     * Constructor for objects of class WordStorage, reads in all the words from txt files.  
     */
    public WordStorage() throws IOException{
        readSimpleWords();
        readMediumWords();
        readHardWords();
        wordDone = true;
    }

    /**
     * Accessor Method for the wordDone variable.
     */
    public boolean getWordDone(){
        return wordDone;
    }

    /**
     * Mutator Method for the wordDone variable.
     */
    public void setWordDone(boolean bool){
        wordDone = bool;
    }

    /**
     * Method that reads in the simple words from the txt file SimpleWords.txt and 
     * stores it in the ArrayList simpleWords.
     */
    public static void readSimpleWords() throws IOException
    {
        String temp = "";	
        Scanner inFile = new Scanner(new File("SimpleWords.txt")).useDelimiter("\r\n");

        while (inFile.hasNext()) {
            temp = inFile.next();
            simpleWords.add(temp);
        }
        inFile.close();
    }

    /**
     * Method that reads in the simple words from the txt file MediumWords.txt and 
     * stores it in the ArrayList simpleWords.
     */
    public static void readMediumWords() throws IOException
    {
        String temp = "";	
        Scanner inFile = new Scanner(new File("MediumWords.txt")).useDelimiter("\r\n");

        while (inFile.hasNext()) {
            temp = inFile.next();
            mediumWords.add(temp);
        }
        inFile.close();
    }

    /**
     * Method that reads in the simple words from the txt file HardWords.txt and 
     * stores it in the ArrayList simpleWords.
     */
    public static void readHardWords() throws IOException
    {
        String temp = "";	
        Scanner inFile = new Scanner(new File("HardWords.txt")).useDelimiter("\r\n");

        while (inFile.hasNext()) {
            temp = inFile.next();
            hardWords.add(temp);
        }
        inFile.close();
    }

    /**
     * Method that randomly chooses a word from the simpleWords ArrayList
     * 
     * @return     a word from the easyWords ArrayList
     */
    public static String getSimpleWord(){
        Random rand = new Random();
        int temp = rand.nextInt(simpleWords.size());
        return simpleWords.get(temp);
    }
    
    /**
     * Method that randomly chooses a word from the mediumWords ArrayList
     * 
     * @return     a word from the mediumWords ArrayList
     */
    public static String getMediumWord(){
        Random rand = new Random();
        int temp = rand.nextInt(mediumWords.size());
        return mediumWords.get(temp);
    }
    
    /**
     * Method that randomly chooses a word from the hardWords ArrayList
     * 
     * @return     a word from the hardWords ArrayList
     */
    public static String getHardWord(){
        Random rand = new Random();
        int temp = rand.nextInt(hardWords.size());
        return hardWords.get(temp);
    }
}