import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * The world that the game is played in.
 * 
 * @author Michael Zou
 * @version April 4, 2016
 */
public class GameWorld extends World
{
    private ArrayList<String> simpleWords = new ArrayList<String>();
    private ArrayList<String> mediumWords = new ArrayList<String>();
    private ArrayList<String> hardWords = new ArrayList<String>();
    HealthBar healthbar = new HealthBar();

    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld() throws IOException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        setBackground("Background.png");
        prepare();
    }

    /**
     * Accessor method for the 'healthbar' variable.
     * 
     * @return     the healthbar variable
     */
    public HealthBar getHealthBar()
    {
        return healthbar;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() throws IOException
    {
        WordStorage wordstorage = new WordStorage();
        addObject(wordstorage, 0, 0);

        GameRunner rounds = new GameRunner();
        addObject(rounds, 0, 0);

        GameStats stats = new GameStats(100, 0, 0);
        addObject(stats, 0, 0);

        ScoreDisplay score = new ScoreDisplay();
        addObject(score, 700, 650);        

        HUD hud = new HUD();
        addObject(hud,640,668);
        
        Player player = new Player();
        addObject(player, 1280/2, 500);
        
        EnemySpawner spawner = new EnemySpawner();
        addObject(spawner, 0, 0);
        
        addObject(healthbar,152,672);

        setPaintOrder(ScoreDisplay.class, TargetLetter.class, GameStats.class, GameRunner.class, WordManager.class, WordStorage.class);
    }
}
