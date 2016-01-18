import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Actor
{
    private static final int SPEED = 5;
    
    public Missile () {
        turn(-90);
    }
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(Missile.SPEED);
        if ( isAtEdge() ) {
            // destroy itself
            destroy();
            return;
        } 
        if (isTouching(Robot.class)) {
            Robot r = getOneIntersectingObject(Robot.class);
            //removeTouching(Robot.class);
            r.destroy();
            destroy();
            return;
        }
        if (isTouching(Bomb.class)) {
            Bomb b = getOneIntersectingObject(Bomb.class);
            //removeTouching(Bomb.class);
            b.destroy();
            destroy();
            return;
        }
            
    }    
    public void destroy() {
        
        getWorld().removeObject(this);
    }
}
