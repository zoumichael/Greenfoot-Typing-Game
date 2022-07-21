import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The letters that will be displayed that the user must type.
 * 
 * @author Michael Zou
 * @version March 10, 2018
 */
public class TargetLetter extends Actor
{
    boolean flashing = false;
    boolean right = false;
    int counter = 0;
    String letterDisplay;

    /**
     * Constructor for objects of class TargetLetter, initializes the letterDisplay based on parameter.
     * 
     * @params: display  the letter that will be displyed
     */
    public TargetLetter(String display){
        String nameOfFile = "LetterUntyped" + display + ".png";
        GreenfootImage file = new GreenfootImage(nameOfFile);
        setImage(file);
        letterDisplay = display;
    }

    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(flashing){
            counter++;
        }

        if(counter == 20 && !right){
            flashing = false;
            counter = 0;
            String nameOfFile = "LetterUntyped" + letterDisplay + ".png";
            GreenfootImage file = new GreenfootImage(nameOfFile);
            setImage(file);
        }
    }

    /**
     * Method that checks to see if the user input is correct; it will find the file that corresponds 
     * with the letter inputed and sets the image depending if the user inputed correctly or not
     * 
     * @param letter    a string that holds the value of a letter
     * @param correct   a boolean that will tell the method if the user input is correct or wrong
     */
    public void setImage(String letter, boolean correct){
        if(correct){
            String nameOfFile = "Letter" + letter + ".png";
            GreenfootImage file = new GreenfootImage(nameOfFile);
            setImage(file);
            flashing = false;
            counter = 0;
            right = true;
        }
        else if(!correct){
            String nameOfFile = "LetterWrong" + letter + ".png";
            GreenfootImage file = new GreenfootImage(nameOfFile);
            setImage(file);
            flashing = true;

            GameWorld gameworld = (GameWorld) getWorld();
            HealthBar healthbar = gameworld.getHealthBar();
            healthbar.loseHealth();
        }
    }
}