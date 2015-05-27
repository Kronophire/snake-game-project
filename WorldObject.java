import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The WorldObject class, the superclass of
 *  obstacle and food, is where it makes a 
 *  boolean and checks if an object in the world
 *  can be eaten or not. The food can be eaten
 *  and the obstacle can't be eaten.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14(2013.12.04)
 */
public class WorldObject extends Actor
{
    //~ Fields ................................................................
    private boolean canBeEaten;
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WorldObject object.
     * 
     * @param canEat checks if an object in the world
     * can be eaten or not.
     */
    public WorldObject(boolean canEat)
    {
        canBeEaten = canEat;
    }


    //~ Methods ...............................................................
    
    /**
     * The boolean for the canBeEaten() is to check if
     * something, the obstacle or food, can be eaten.
     * In this case, the food can be eaten but not the obstacle.
     * 
     * @return canBeEaten saying that the worldObject, food, can be
     * eaten.
     */
    public boolean canBeEaten()
    {
        return canBeEaten;
    }

}
