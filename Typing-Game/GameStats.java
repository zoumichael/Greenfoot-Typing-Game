import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class that stores score-related information. Health, number of zombies killed, and score. 
 * 
 * @author Michael Zou
 * @version April 4, 2018
 */
public class GameStats extends Actor
{
    private int health;
    private int numZombiesKilled;
    private int score;

    /**
     * Constructor for GameStats
     * 
     * @param  h      a int value that represents the health of the player
     * @param  z      a int value that represents the number of zombies that the player has killed
     * @param  s      a int value that represents the score
     */
    public GameStats(int h, int z, int s){
        health = h;
        numZombiesKilled = z;
        score = s;
    }

    /**
     * Accessor method for the 'health' variable.
     * 
     * @return     the health variable
     */
    public int getHealth(){ 
        return health; 
    }

    /**
     * Accessor method for the 'numZombiesKilled' variable.
     * 
     * @return     the numZombiesKilled variable
     */
    public int getZombiesKilled(){
        return numZombiesKilled;
    }

    /**
     * Accessor method for the 'score' variable.
     * 
     * @return     the score variable
     */
    public int getScore(){
        return score;
    }

    /**
     * Mutator method for the 'health' variable.
     * 
     * @param  h    the new value of variable health
     */
    public void setHealth(int h){
        health = h;
    }

    /**
     * Mutator method for the 'score' variable.
     * 
     * @param  h    the new value of variable score
     */
    public void setScore(int s){
        score = s;
    }

    /**
     * Mutator method for the 'numZombiesKilled' variable.
     * 
     * @param  h    the new value of variable numZombiesKilled
     */
    public void setZombieKilled(int z){
        numZombiesKilled = z;
    }
}