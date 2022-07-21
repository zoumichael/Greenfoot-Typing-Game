import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The superclass for all Enemys. Contains the variables and methods shared by all Enemys.
 * 
 * @author Michael Zou
 * @version April 3, 2018
 */
public abstract class Enemy extends Actor
{
    protected boolean touchingPlayer;
    protected int health;
    protected int speed;
    protected int damage;
    
    /**
     * Constructor for objects of class Enemy, initializes the speed, damage and health of the enemy.
     */
    public Enemy(){
        touchingPlayer = false;
        health = 100;
    }
    
    /**
     * Act - do whatever the Enemys wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnTowardsPlayer();
        checkTouching();
        //health--;
        if(!touchingPlayer)
            move(speed);
        else{
            
        }
        if(health<=0){
            /*Player player = (Player) getWorld().getObjects(Player.class).get(0); 
            player.setTargetLocked(false);*/
            getWorld().removeObject(this);
        }
    }  
    
    /**
     * Method that turns the enemy towards the player.
     */
    public void turnTowardsPlayer(){
        Player player = (Player) getWorld().getObjects(Player.class).get(0);  
        turnTowards(player.getX(), player.getY());  
    }
    
    /**
     * Method that checks if the enemy is touching the player, if it is, change the touching player to true.
     */
    public void checkTouching(){
        Player player = (Player) getWorld().getObjects(Player.class).get(0);  
        double distance = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));  
        if(distance < 10)
            touchingPlayer = true;
    }
    
    public void takeDamage(int d){
        health -= d;
    }

}