import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Object that displays the score.
 * 
 * @author Michael Zou
 * @version April 4, 2018
 */
public class ScoreDisplay extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GameStats stats = (GameStats) getWorld().getObjects(GameStats.class).get(0);
        String score = Integer.toString(stats.getScore());
        Color clear = new Color(0,0,0,0);
        setImage(new GreenfootImage(score, 50, Color.BLACK, clear));
    }    
}