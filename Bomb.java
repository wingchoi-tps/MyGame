import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private static int count = 0;
    private static final int MAXBOMB = 5;
    
    private static final int SPEED = 5;
    
    private boolean stop = false;
    
    public Bomb () {
        turn (90);
        if (!Bomb.addBombCount()) {
            // destroy bomb 
            stop = true;
        }
    }
    
    public static void setup() {
        count = 0;
    }
    public static boolean addBombCount () {
        count++;
        if (count > MAXBOMB) {
            //count--;
            return false;
        }
        return true;
    }
    public static void removeBombCount() {
        count--;
    }
    public static int getBombCount() {
        return count;
    }
    public static boolean canMakeNewBomb() {
        if (count < MAXBOMB) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move (Bomb.SPEED);
        if ( isAtEdge() ) {
            // destroy itself
            destroy();
            return;
        }
        if ( stop ) {
            destroy();
            return;
        }
        
    }
    
    public void destroy() {
        Bomb.removeBombCount();
        getWorld().removeObject(this);
    }
}
