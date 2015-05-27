------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: PacSnake

PURPOSE OF PROJECT: To create my own game, which is a classic Snake game.

VERSION or DATE: 2.2.1-14 (2013.12.04)

HOW TO START THIS PROJECT: Uses the similar or same concept of Snake. The snake would
created in the center of the world. There would be obstacles or walls added around the edge
of the world so that when the snake hits the obstacle, the game is over. The obstacles are also added 
randomly anywhere into the world, specifically 6 obstacles. When the snake is created in the world,
and when the game starts running, it would move forward by 10 units space in every act round. 
You control the snake by pressing the "A"and "D" or, Left or Right key. There is an eat method where
if the snake collides with a food in the world, there will be a snake body block that will be added into
the world. In order, the first snake block, which is the snake head block, will be stored in a block list
before being added to the world using the add block method. When the addblock method is executed, 
the block stored in the list will be added onto the x and y axis of its previous block. So for example, 
if the snake head block is the only thing in the world and when it eats a food, a snake body block
will be added on top of the head block by getting the x and y axis of the head and set the coordinates of
the block being added to its previous block, which is the head block in this case. When the snake moves
along the world, the body block would be following the snake by setting its own new x and y axis by 
getting the previous block's x and y axis.

AUTHORS: Christopher Aska Toda

USER INSTRUCTIONS: Use the "A" and "D" or Left and Right keys to turn the direction of the snake 90
degrees. The snake would be moving by its own so the player wouldn't be controlling the speed or movement
of the snake.

Inheritance: The SnakeBlock acts as the super class. The BodyBlock and HeadBlock are sub-classes and
inherits from the SnakeBlock class. The BodyBlock and HeadBlock are added into a block list, where the
headblock would be added from the beginning when the game starts. The BodyBlock would get added to
the list when the snake eats a food in the world. Therefore the BodyBlock and HeadBlock are added
into the ArrayList created in the SnakeBlock super class and stores the blocks.

Polymorphism: The canBeEaten is made inside the worldObject where the items that are created under it
are the food and the obstacle. The food can be eaten and the obstacle can't. Returns true when snake collides
with food and eats it.

Container: The list for blocks being added in the SnakeBlock class in the Snake main actor class.

Nested loop: One of the nested loop is the adding of the obstacles that are added randomly into the 
world and also the obstacle covering the edges of the world. The creating of the cherry is also
a nest for loop, creating random food in the world. All found in the Background class. Another
nested loop is the for loop in the Snake class, in the follow method. The follow method is getting
the blocks from the list for SnakeBlock and using by adding the snake blocks into the world so that
it follows the snake blocks, including the head block and the body blocks.

Losing the game: The game will be lost when the Snake headblock hits the obstacle.

Difficulty: Note that sometimes the food or cherry would be added at obscure places such as being
very close to walls or obstacles. That is because it adds the difficulty in the game. It IS still 
possible to get the food that can be seen to be "inside" the wall, however the food is not really 
inside the wall rather the center of the food might be a few axis away from the wall. 