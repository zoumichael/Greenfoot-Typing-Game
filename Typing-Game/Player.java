import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private boolean targetLocked = false;
    private int counter = 0;
    
    public Player(){
        setImage("player1.png");
    }
    
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnTowardsEnemy();

    }
    
    public void turnTowardsEnemy(){
        ArrayList<Enemy> enemies = (ArrayList<Enemy>) getWorld().getObjects(Enemy.class);
        if(!enemies.isEmpty()){
            Enemy closest = enemies.get(0);
            double distance = Math.sqrt(Math.pow(closest.getX() - this.getX(), 2) + Math.pow(closest.getY() - this.getY(), 2));
            for(Enemy ref : enemies){
                double temp = Math.sqrt(Math.pow(ref.getX() - this.getX(), 2) + Math.pow(ref.getY() - this.getY(), 2));
                if(temp < distance){
                    distance = temp;
                    closest = ref;
                }
            }
            turnTowards(closest.getX(), closest.getY());
        }
    }
}