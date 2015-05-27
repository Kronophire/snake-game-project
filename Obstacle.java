import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Obstacle class, subclass of WorldObject,
 *  has the obstacle object and imaged as a wall.
 *  The obstacle will end the game when the snake
 *  collides with it.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14(2013.12.04)
 */
public class Obstacle extends WorldObject
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Obstacle object. The image
     * is allowed for commercial usage.
     * Retrieved from http://www.softicons.com/free-icons/toolbar-icons/
     * toolbar-2-icon-set-by-anna-shlyapnikova/brick-wall-icon.
     */
    public Obstacle()
    {
        super(false);
    }


    //~ Methods ...............................................................


}
