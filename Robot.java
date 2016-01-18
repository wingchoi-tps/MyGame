import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    
    private static final int HSPEED = 3;
    private static final int VSPEED = 25;
    private static ArrayList<Robot> robotList = new ArrayList<Robot>();
    
    private int moveDirection = 1;
        
    public static int getRobotCount() {
        return robotList.size();
    }
    public static void setup() {
        robotList.clear();
    }
    
    public Robot () {
        Robot.robotList.add(this);
    }
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if ( !isAtEdge() ) {
            move(moveDirection * Robot.HSPEED);
            
            int r = (int) (Math.random() * 210);
            if ((r == 100) && (Bomb.canMakeNewBomb())) {
                getWorld().addObject(new Bomb(), getX(), getY());
            }
        } else {
            advance();
        }

    }   
    
    public void advance() {
        if (moveDirection == 1) {
            moveDirection = -1;
        } else {
            moveDirection = 1;
        }
        move(moveDirection * 1);
        turn(90);
        move(Robot.VSPEED);
        turn(-90);
    }
    
    public void destroy() {
        Robot.robotList.remove(this);
        getWorld().removeObject(this);
    }
}
