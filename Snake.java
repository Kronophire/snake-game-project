import sofia.micro.*;
import java.util.*;
import sofia.util.Random;
import sofia.graphics.TextShape;
import sofia.graphics.Color;

//-------------------------------------------------------------------------
/**
 *  The Snake class, being the main actor,
 *  contains the method for the snake to be able to move
 *  around manually. When it eats a food in the world,
 *  the snake gets longer by adding blocks following
 *  the snake's HeadBlock first then any block following it.
 *  Also, when the food is being eaten in the world,
 *  another food would be randomly added into the world
 *  after colliding with the snake's headblock.
 *  When the snake's headblock collides with an 
 *  obstacle, the game is over. 
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14(2013.12.04)
 */
public class Snake extends Actor
{
    //~ Fields ................................................................
    private List<SnakeBlock> blocks;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Snake object. Creates an
     * ArrayList of snake blocks after addBlock
     * is executed. When storing the snake blocks
     * as blocks, it would get added into the world
     * after each time the snake eats a food and the
     * snake blocks will follow the snake.
     * 
     * @param w The initialized world
     * @param x The x-axis of the snake
     * @param y The y-axis of the snake
     */
    public Snake(World w, int x, int y)
    {
        blocks = new ArrayList<SnakeBlock>();
        SnakeBlock block1 = new HeadBlock();

        w.add(this);
        getWorld().add(block1, x, y);

        blocks.add(block1);

    }

    //~ Methods ...............................................................

    /**
     * The dpadEastIsDown() method uses
     * the right-arrow key to rotate 90 degrees right.
     */
    public void dpadEastIsDown()
    {
        blocks.get(0).setRotation(blocks.get(0).getRotation() + 90);

    }    

    /**
     * The dpadWestIsDown() method uses
     * the left-arrow key to rotate 90 degrees left.
     */
    public void dpadWestIsDown()
    {
        blocks.get(0).setRotation(blocks.get(0).getRotation() - 90);

    }

    /**
     * The addBlock() method creates and add 
     * new snake blocks, first one that will be following
     * the snake's headblock, then the next blocks 
     * will follow its previous blocks by getting their
     * coordinates.
     */
    public void addBlock()
    {
        SnakeBlock block1 = new BodyBlock();

        int x = blocks.get(blocks.size() - 1).getGridX();
        int y = blocks.get(blocks.size() - 1).getGridY();

        getWorld().add(block1, x, y);

        blocks.add(block1);

    }

    /**
     * The eat() method is when the snake's headblock
     * collides with a food added into the world, then the
     * food would get removed and more food will be added
     * randomly anywhere into the world. When the snake
     * collides with an obstacle in the world, then the game
     * is over. A big red text around the center would appear
     * and say "Game Over".
     */
    public void eat()
    {
        WorldObject cherry = blocks.get(0)
             .getOneIntersectingObject(WorldObject.class);
        if (cherry != null)
        {
            if (cherry.canBeEaten())
            {
                cherry.remove();
                int x = Random.generator().nextInt(getWorld().getWidth());
                int y = Random.generator().nextInt(getWorld().getHeight());
                getWorld().add(cherry, x, y);
                addBlock();
            }
            else
            {
                WorldObject wall = blocks.get(0)
                    .getOneIntersectingObject(WorldObject.class);
                if (!wall.canBeEaten())
                {
                    getWorld().stop();
                    TextShape text = new TextShape("Game Over"); 
                    getWorld().add(text, 250, 200); 
                    text.setTypeSize(75); 
                    text.setColor(Color.red); 
                }
            }

        }
    }

    /**
     * The follow() method gets executed when the snake
     * eats a food, then a block will be added into the 
     * world from the list it's being stored in. 
     */
    public void follow()
    {
        for (int i = blocks.size() - 1; 1 <= i; i--)
        {
            int x = blocks.get(i - 1).getGridX();
            int y = blocks.get(i - 1).getGridY();

            blocks.get(i).setGridX(x);
            blocks.get(i).setGridY(y);
        }

    }

    /**
     * The act() method for the Snake class.
     */
    public void act()
    {
        blocks.get(0).move(10);
        follow();
        eat();
    }
}
