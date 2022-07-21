import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that creates words/rounds if the current word has been typed.
 * 
 * @author Michael Zou  
 * @version March 15, 2018
 */
public class GameRunner extends Actor
{
    //int variable that stores the number of words solved
    private int numWords;
    
    /**
     * Constructor for objects of class GameRunner, initializes numWords to zero.
     */
    public GameRunner(){
        numWords = 0;
    }
    
    /**
     * Act - do whatever the RoundManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        WordStorage storage = (WordStorage) getWorld().getObjects(WordStorage.class).get(0);
        if(storage.getWordDone()){
            //If the user has typed less than 10 words, only easy words will be used. 
            //After 10 words, medium words are added. After 20 words, hard words are added.
            
            if(numWords > 20){
                WordManager wordmanager = new WordManager(true, true);
                getWorld().addObject(wordmanager, 0, 0);
            }
            else if(numWords > 10){
                WordManager wordmanager = new WordManager(true, false);
                getWorld().addObject(wordmanager, 0, 0);
                numWords++;
            }
            else{
                WordManager wordmanager = new WordManager(false, false);
                getWorld().addObject(wordmanager, 0, 0);
                numWords++;
            }
            
            storage.setWordDone(false);
        }
    }    
}