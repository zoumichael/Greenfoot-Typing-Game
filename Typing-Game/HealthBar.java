import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The object that displays and stores the healthbar of the player.
 * 
 * @author (your name) 
 * @version April 4, 2018
 */
public class HealthBar extends Actor
{
    int health = 10;
    int healthBarWidth = 210;
    int healthBarHeight = 22;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    
    /**
     * Constructor for objects of class HealthBar.
     */
    public HealthBar()
    {
        update();
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();
    }

    /**
     * Method that constantly updates and draw the healthbar.
     */
    public void update()
    {
        //makes white border around health bar
        setImage (new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage box = getImage();
        box.setColor(Color.WHITE);
        box.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);

        //makes red health bar
        box.setColor(Color.RED);
        box.fillRect(1, 1, health * pixelsPerHealthPoint, healthBarHeight);
    }

    /**
     * Method that decreases the 'health' variable by 1.
     */
    public void loseHealth()
    {
        health--;
        if(health == 0){
            try{
                Greenfoot.setWorld(new GameWorld());
            }
            catch(Exception IOException){
            
            }
        }
    }    
}