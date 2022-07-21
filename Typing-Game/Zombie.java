import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Enemy
{
    private int animationCount;   //Speed of the animation
    private int frame;            //Used to reference the walk frams

    private GreenfootImage[] walk;
    private GreenfootImage[] attack;
    
    public Zombie(){
        //initialize variables
        animationCount = 1;
        frame  = 1;
        speed = 1;

        walk = new GreenfootImage[17];
        for(int i = 1; i<= 17; i++)
            walk[i-1] = new GreenfootImage("ZombieWalk" + i + ".png");
            
    }

    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        turnTowardsPlayer();
        checkTouching();
        //health--;
        if(!touchingPlayer){
            move(speed);
            animateWalk();
        }
        else{
            try{
                Greenfoot.setWorld(new GameWorld());
            }
            catch(Exception IOException){
            
            }
        }
        if(health<=0){
            /*Player player = (Player) getWorld().getObjects(Player.class).get(0); 
            player.setTargetLocked(false);*/
            getWorld().removeObject(this);
        }
    } 

    private void animateWalk(){
        animationCount++;
        if(animationCount >= 5){
            if(frame >= walk.length)
                frame = 0;
            setImage(walk[frame]);
            frame++;
            animationCount = 0;
        }
    }
    
    public void animateAttack(){
        animationCount++;
        if(animationCount >= 5){
            if(frame >= attack.length)
                frame = 0;
            setImage(attack[frame]);
            frame++;
            animationCount = 0;
        }
    }
}
