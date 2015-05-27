import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  The SnakeTest class is where all the
 *  methods from the Snake class is being
 *  tested.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14(2013.12.04)
 */
public class SnakeTest extends TestCase
{
    //~ Fields ................................................................
    private Snake snake;
    private Background world;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SnakeTest test object.
     */
    public SnakeTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        world = new Background();
        snake = world.getObjects(Snake.class).get(0);

    }

    // ----------------------------------------------------------
    /**
     * Tests the dpadEastIsDown() method to check
     * if the snake is rotating to the right by
     * +90 degrees.
     */
    public void testDpadEastIsDown()
    {
        snake.dpadEastIsDown();

        assertEquals((int) snake.getRotation(), 0);

    }

    /**
     * Tests the dpadEastIsDown() method to check
     * if the snake is rotating to the right by
     * -90 degrees.
     */
    public void testDpadWestIsDown()
    {
        snake.dpadWestIsDown();

        assertEquals((int) snake.getRotation(), 0);

    }

    /**
     * Tests the addBlock() method of the Snake class.
     * Checking if a block is added to the world.
     */
    public void testAddBlock()
    {
        snake.addBlock();

        assertEquals(1, world.getObjects(BodyBlock.class).size());
    }

    /**
     * Tests the eat() method of the Snake class.
     * Checks when a food is added into the world
     * infront of the Snake, it should eat it.
     */
    public void testEat()
    {
        Food food = new Food();

        world.add(food, 250, 250);
        snake.act();

        assertEquals(1, world.getObjects(BodyBlock.class).size());
        assertEquals(2, world.getObjects(Food.class).size());

    }

    /**
     * Tests the follow() method of the Snake class.
     * Checks that after the snake eats a food in the
     * world, a body block would be added to the world
     * and the block would start following on after
     * the other, following the snake headblock.
     */
    public void testFollow()
    {
        Food food = new Food();
        Food food2 = new Food();
        Food food3 = new Food();

        world.add(food, 251, 250);
        world.add(food2, 255, 250);
        world.add(food3, 280, 250);

        run(world, 4);

        assertTrue(world.getObjects(BodyBlock.class).size() > 0);
    }

    /**
     * Tests the hitsObstacle() method of the Snake class.
     */
    public void testHitsObstacle()
    {
        run(world, 50);

        assertEquals(1, world.getObjects(HeadBlock.class).size());
    }

    /**
     * Tests the act() method of the Snake class.
     * The act() contains the move(), follow(),
     * eat(), and hitsObstacle() method.
     */
    public void testAct()
    {
        Food food = new Food();

        world.add(food, 251, 250);

        run(world, 50);

        assertEquals(1, world.getObjects(HeadBlock.class).size());
    }

}
