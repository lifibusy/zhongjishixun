import info.gridworld.actor.*;
import info.gridworld.grid.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.awt.Color;

public class NewCritterTest
{
	private ActorWorld world;
	private NewCritter critter;
	
	@Before
	public void setUp()
	{
		world = new ActorWorld();
		critter = new NewCritter();
	}

	@Test
	public void testFlower()
	{
		Location critterLoc = new Location(5,5);
		Location flowerLoc = new Location(5,6);
		world.add(critterLoc, critter);
		world.add(flowerLoc, new Flower());
		world.step();
		Grid<Actor> gr = critter.getGrid();
		assertEquals(null, gr.get(flowerLoc));

	}

	@Test
	public void testRock()
	{
		Location critterLoc = new Location(5, 5);
		Location rockLoc = new Location(4,5);
		Rock rock = new Rock();
		
		world.add(critterLoc, critter);
		world.add(rockLoc, rock);
		world.step();
		assertEquals(new Location(3,5), rock.getLocation());
	}

	@Test
	public void testBug()
	{
		Location bugLoc = new Location(5, 5);
		Location critterLoc = new Location(4, 5);
		Bug bug = new Bug();
		world.add(bugLoc, bug);
		world.add(critterLoc, critter);
		world.step();
		assertEquals(Color.RED, bug.getColor());
	}
}
