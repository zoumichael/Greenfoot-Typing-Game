import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "Standard" bullet that is created, enough to 2HKO normal zombies.
 * 
 * @author Michael Zou
 * @version April 5, 2018
 */
public class PistolBullet extends Projectile
{
    /**
     * Constructor for objects of class PistolBullet, initializes the damage.
     */
    public PistolBullet(){
        super();
        setImage("MGunBullet.png");
        damage = 50;
    }
    
    /**
     * Act - do whatever the PistolBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!lockedOn){
            turnTowardsEnemy();
            lockedOn = true;
        }
        move(10);
        remove();
    }    
}
