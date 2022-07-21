import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * An object that spawns zombies for the user to fight.
 * 
 * @author Michael Zou
 * @version April 4, 2018
 */
public class EnemySpawner extends Actor
{
    //Variables that determine whether a certain zombie can be spawned or not
    private boolean regularEnemys;
    private boolean tankyEnemys;
    private boolean fastEnemys;
    private boolean bossEnemys;
    
    private int counter;
    private int minTime;
    private int maxTime;
    
    /**
     * Constructor for objects of class EnemySpawner, initializes the variables.
     */
    public EnemySpawner(){
        //Only regular zombies will be spawned from the beginning.
        regularEnemys = true;
        tankyEnemys = false;
        fastEnemys = false;
        bossEnemys = false;
        
        counter = 0;
        maxTime = 100;
        minTime = 10; 
    }
    
    /**
     * Act - do whatever the EnemySpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter++;
        if(counter > maxTime){
            spawnNormalEnemy();
            counter = 0;
        }
    }   
    
    /**
     * Method that can only spawn a normal zombie.
     */
    public void spawnNormalEnemy(){
        int[] loc = chooseLocation();
        Zombie Z = new Zombie();
        getWorld().addObject(Z, loc[0], loc[1]);
    }
    
    /**
     * Method that randomly chooses a point along the top half of the border.
     * 
     * @return     a two-dimesional array that stores the coordinates
     */
    public int[] chooseLocation(){
        int[] coordinates = new int[2];
        
        Random rand = new Random();
        int whichBorder = rand.nextInt(3);
        if(whichBorder == 0){
            //Spawns from the left border.
            coordinates[0] = 0;
            coordinates[1] = rand.nextInt(getWorld().getHeight()/2);
        }
        else if(whichBorder == 1){
            //Spawns from the right border.
            coordinates[0] = getWorld().getWidth();
            coordinates[1] = rand.nextInt(getWorld().getHeight()/2);
        }
        else if(whichBorder == 2){
            //Spawns from the top border.
            coordinates[0] = rand.nextInt(getWorld().getWidth());
            coordinates[1] = 0;
        }
        
        return coordinates;
    }
}
