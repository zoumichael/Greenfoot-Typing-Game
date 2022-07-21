import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A object that displays the HUD image.
 * 
 * @author Michael Zou
 * @version April 4, 2018
 */
public class HUD extends Actor
{
    public HUD(){
        setImage("HUD.png");
    }
    
    /**
     * Act - do whatever the GameRunner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage hud = new GreenfootImage("HUD.png");
        setImage(hud);
    }    
}