package Logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class Boss_LogicTest {

	@Test
	public void test_setgetX_Coordinate() {
		Boss_Logic s = new Boss_Logic(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate());
	}
	@Test
	public void test_setgetY_Coordinate() {
		Boss_Logic s = new Boss_Logic(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}

	@Test
	public void test_delete() {
		Boss_Logic s = new Boss_Logic(300, 300);
		s.delete();
		assertEquals("x coordinate is set to -1000", -1000, s.getX_coordinate());
		assertEquals("y coordinate is set to -1000", -1000, s.getY_coordinate());
	}

	@Test
	public void test_moveRandom() {
		Boss_Logic s = new Boss_Logic(300, 300);
		s.moveRan();
		assertTrue("Check if Boss_Logic is within the boundary of the scene", s.getX_coordinate() < 600);
		assertFalse("Check if Boss_Logic is within the boundary of the scene", s.getX_coordinate() > 500);
		assertTrue("Check if Boss_Logic is within the boundary of the scene", s.getY_coordinate() > 0);
		assertFalse("Check if Boss_Logic is within the boundary of the scene", s.getY_coordinate() < 0);
	}
	@Test
	public void test_setgetBoss_LogicShoot(){
		Boss_Logic s = new Boss_Logic(300, 300);
		s.setBossShoot(true);
		assertEquals("Boss_Logic can still therfore true", true, s.doesBossShoot());
	}
	@Test
	public void test_setgetMovement() {
		Boss_Logic s = new Boss_Logic(300, 300);
		s.setMovement(5);
		assertEquals("Amount of pixels move is 5", 5, s.getMovement());
	}
	@Test
	public void test_enemyShoot() {
		Boss_Logic s = new Boss_Logic(300, 300);
		s.isBossDead();
		assertEquals("Boss_Logic is dead therefor can not shoot", false, s.doesBossShoot());
	}
}
