import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);
        Bomb.setup();
        Robot.setup();
        
        // setup Aliens
        int startx = 50;
        
        for (int x = startx; x < 300; x += 50) {
            for ( int y = startx; y < 300; y += 50) {
            addObject(new Robot(),x,y);
            }
        }

        // setup Hero
        addObject(new Hero(), 400,480);
        //addObject(new Hero(), 200,480);
        
    }
}
