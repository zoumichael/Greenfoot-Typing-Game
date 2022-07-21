import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * A object that is created for each specific word, this object displays the letters, checks
 * user input, and removes itself once the word has been typed out.
 * 
 * @author Michael Zou
 * @version March 26, 2018
 */
public class WordManager extends Actor
{
    private int lengthOfWord;
    private int targetLoc = 0;
    private String word;
    private ArrayList<TargetLetter> letters = new ArrayList<TargetLetter>();
    private boolean hasRun = false;

    /**
     * Constructor for objects of class WordManager, initializes the word variable based on parameters.
     * Chooses the word variable based on difficulty, decided by the parameters.
     * 
     * @param  medium   a boolean that specifics if medium words are included in the word pool
     * @param  hard   a boolean that specifics if hard words are included in the word pool
     */
    public WordManager(boolean medium, boolean hard){
        Random rand = new Random();
        if(hard){
            int choose = rand.nextInt(3);
            if(choose == 0)
                word = WordStorage.getSimpleWord();
            else if(choose == 1)
                word = WordStorage.getMediumWord();
            else if(choose == 2)
                word = WordStorage.getHardWord();
        }
        else if(medium){
            int choose = rand.nextInt(2);
            if(choose == 0)
                word = WordStorage.getSimpleWord();
            else if(choose == 1)
                word = WordStorage.getMediumWord();
        }
        else{
            word = WordStorage.getSimpleWord();
        }

        targetLoc = 0;
        lengthOfWord = word.length();

        for(int i = 0; i<lengthOfWord; i++){
            String temp = word.substring(i, i+1).toUpperCase(); 
            letters.add(new TargetLetter(temp));
        }
    }

    /**
     * Act - do whatever the GameRunner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GameStats stats = (GameStats) getWorld().getObjects(GameStats.class).get(0);
        if(!hasRun){
            displayTargetWord();
            hasRun = true;
        }
        String key = Greenfoot.getKey();
        if(key != null){
            if(key.equals(word.substring(targetLoc, targetLoc+1))){
                String let = word.substring(targetLoc, targetLoc+1).toUpperCase();
                letters.get(targetLoc).setImage(let, true);
                targetLoc++;    
            }
            else{
                String let = word.substring(targetLoc, targetLoc+1).toUpperCase();
                letters.get(targetLoc).setImage(let, false);
                stats.setScore(stats.getScore()-2);
            }
        }

        WordStorage storage = (WordStorage) getWorld().getObjects(WordStorage.class).get(0);
        if(targetLoc == lengthOfWord){
            storage.setWordDone(true);
            List<TargetLetter> lettersToRemove = getWorld().getObjects(TargetLetter.class);
            for(TargetLetter temp : lettersToRemove){
                getWorld().removeObject(temp);
            }
            stats.setScore(stats.getScore()+10*(lengthOfWord-3)); //Adds score to the characters stats, depending on how difficult the word is
            getWorld().addObject(new PistolBullet(), 640, 500);
            getWorld().removeObject(this);
        }
    }

    /**
     * Method that displays the target word at the beginning of the round.
     */
    public void displayTargetWord(){
        int imageWidth = 40;

        //find the x-coordinate that we will place the first block at
        int startingPointX = 660 - (lengthOfWord * 20);
        int startingPointY = 700;

        //put the target letters up
        for(int i = 0; i<lengthOfWord; i++){
            TargetLetter temp = letters.get(i);
            getWorld().addObject(temp, startingPointX + i*imageWidth, startingPointY);
        }
    }
}