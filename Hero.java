import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    public static final int HEROSPEED = 3;
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkKeyPress();
        
        if (Robot.getRobotCount() < 1) {
            World w = getWorld();
            w.showText("You've Won !",w.getWidth()/2,w.getHeight()/2);
        }
    }    
    
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("left")) {
            move(-Hero.HEROSPEED);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(Hero.HEROSPEED);
        }
        if (Greenfoot.isKeyDown("up")) {
            getWorld().addObject(new Missile(),getX(),getY());
        }
    }
    
    public void destroy() {
        getWorld().removeObject(this);
    }
}
