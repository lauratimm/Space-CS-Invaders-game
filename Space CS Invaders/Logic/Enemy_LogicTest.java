package Logic;
import static org.junit.Assert.*;

import org.junit.Test;

public class Enemy_LogicTest {

	@Test
	public void test_setgetX_Coordinate() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate());
	}
	@Test
	public void test_setgetY_Coordinate() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}
	@Test
	public void test_setgetDead() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.setDead(false);
		assertEquals("Enemy_Logic is still alive therefore not dead", false, s.getDead());
	}
	@Test
	public void test_setMovement() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.setMovement(50);
		assertEquals("set amount of pixels moved per move is 50 unit", 50, s.getMovement());
	}
	@Test
	public void test_delete() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.delete();
		assertEquals("x coordinate is set to -1000", -1000, s.getX_coordinate());
		assertEquals("y coordinate is set to -1000", -1000, s.getY_coordinate());
	}

	@Test
	public void test_moveRandom() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.moveRan();
		assertTrue("Check if Enemy_Logic is within the boundary of the scene", s.getX_coordinate() < 600);
		assertFalse("Check if Enemy_Logic is within the boundary of the scene", s.getX_coordinate() > 500);
		assertTrue("Check if Enemy_Logic is within the boundary of the scene", s.getY_coordinate() > 0);
		assertFalse("Check if Enemy_Logic is within the boundary of the scene", s.getY_coordinate() < 0);
	}
	@Test
	public void test_Enemy_LogicShoot() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.setDead(false);
		assertEquals("Enemy_Logic is dead therefor can not shoot", false, s.getShoot());
	}
	@Test
	public void test_setgetShoot() {
		Enemy_Logic s = new Enemy_Logic(300, 300);
		s.setShoot(true);
		assertEquals("Enemy_Logic can shoot therfor true", true, s.getShoot());
	}
}