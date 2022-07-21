import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Superclass of all Projectiles
 * 
 * @author Michael Zou
 * @version April 5, 2016
 */
public abstract class Projectile extends Actor
{
    protected boolean lockedOn;
    protected int damage;

    /**
     * Constructor for objects of class Projectiles, initializes the lockedOn variable.
     */
    public Projectile(){
        lockedOn = false;
    }

    /**
     * Method that turns the projectile towards the closets enemy.
     */
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

    /**
     * Method that checks if the projectile should be removed from the world. 
     * Remove this object if its out of bounds or comes into contact with an
     * enemy.
     */
    public void remove(){
        Enemy a = (Enemy) getOneIntersectingObject(Enemy.class);
        if(a != null){ 
            a.takeDamage(damage);
            getWorld().removeObject(this);
            return;
        }

        if(getX() <= 0 || getX() >= getWorld().getWidth() || getY() <= 0 || getY() >= getWorld().getHeight()){
            getWorld().removeObject(this);
            return;
        }
    }
}
