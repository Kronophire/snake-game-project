import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  The Background class, being the World class,
 *  is where the game is being played on. The snake, 
 *  obstacles, and food are added into this world.
 *  The snake would start at the center of the world.
 *  The obstacles are being added randomly anywhere into
 *  the world, at a fix number of 6 obstacles.
 *  Just one food is being added randomly anywhere
 *  into the world and spawns each time it gets eaten
 *  by the snake.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14(2013.12.04)
 */
public class Background extends World
{
    //~ Fields ................................................................
   

    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Background object. A Snake object
     * would be created and added in the center of the world.
     * One food would be added randomly anywhere into
     * the world. Six obstacles will be added randomly
     * anywhere into the world. 499 Obstacles would
     * be added 
     */
    public Background()
    {
        super(500, 500, 1);
        Snake snake = new Snake(this, 250, 250);
        add(snake);

        Food food = new Food();
        int x = Random.generator().nextInt(getWidth());
        int y = Random.generator().nextInt(getHeight());
        this.add(food, x, y);
        
        for (int i = 0; i < 6; i++)
        {
            int xVal = Random.generator().nextInt(getWidth());
            int yVal = Random.generator().nextInt(getHeight());
            
            if (xVal > 230 && xVal < 270 || yVal > 230 && yVal < 270)
            {
                i--;
            }
            else
            {
                Obstacle wall = new Obstacle();
                this.add(wall, xVal, yVal);
            }
        }
        
        for (int i = 0; i < 500; i++)
        {   
            Obstacle wall = new Obstacle();
            this.add(wall, i, 0);
            
            Obstacle wall2 = new Obstacle();            
            this.add(wall2, 0, i);
            
            Obstacle wall3 = new Obstacle();            
            this.add(wall3, i, this.getHeight());

            Obstacle wall4 = new Obstacle();            
            this.add(wall4, this.getWidth(), i);        
        }
        
    }

    //~ Methods ...............................................................

}
