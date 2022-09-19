package Logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class Avatar_LogicTest {

	@Test
	public void test_setgetX_Coordinate() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate());
	}
	@Test
	public void test_setgetX_Coordinate_Negative() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setX_coordinate(-500);
		assertEquals("x = -500", -500, s.getX_coordinate());
	}
	@Test
	public void test_setgetY_Coordinate() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}
	@Test
	public void test_setgetY_Coordinate_Negative() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setY_coordinate(-500);
		assertEquals("y = -500", -500, s.getY_coordinate());
	}
	@Test
	public void test_setgetMovement_moveLeft() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setMovement(20);
		s.moveLeft();
		assertEquals("Avatar moves 20 units left", 280, s.getX_coordinate());
		assertEquals("Avatar's movement is 20 units", 20, s.getMovement());
	}
	@Test
	public void test_setgetMovement_moveRight() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setMovement(15);
		s.moveRight();
		assertEquals("Avatar moves 15 units left", 315, s.getX_coordinate());
		assertEquals("Avatar's movement is 20 units", 15, s.getMovement());
	}
	@Test
	public void test_setgetMovement_moveUp() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setMovement(10);
		s.moveUp();
		assertEquals("Avatar moves 10 units left", 290, s.getY_coordinate());
		assertEquals("Avatar's movement is 10 units", 10, s.getMovement());
	}
	@Test
	public void test_setgetMovement_moveDown() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setMovement(5);
		s.moveDown();
		assertEquals("Avatar moves 5 units left", 305, s.getY_coordinate());
		assertEquals("Avatar's movement is 5 units", 5, s.getMovement());
	}
	@Test
	public void test_setgetShoots_true() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setShoots(true);
		assertEquals("Avatar can still shoot therfore true", true, s.getShoots());
	}
	@Test
	public void test_setgetShoots_false() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setShoots(false);
		assertEquals("Avatar can not shoot therfore false", false, s.getShoots());
	}
	@Test
	public void test_setgetEnemies_killed() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setEnemies_killed(3);
		assertEquals("Avatar has killed 3 enemies", 3, s.getEnemies_killed());
	}
	@Test
	public void test_setgetEnemies_killed_negative() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setEnemies_killed(-4);
		System.out.println(s.getEnemies_killed());
		assertEquals("Enemies killed set to 0", 0, s.getEnemies_killed());
	}
	@Test
	public void test_moveLeft() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.moveLeft();
		assertEquals("x move 10 unit to the left", 290, s.getX_coordinate());
	}
	@Test
	public void test_moveLeft_OutOfRange() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setX_coordinate(0);
		s.moveLeft();
		assertEquals("x should not change since the Avatar_Logic can not move left ", 0, s.getX_coordinate());
	}
	@Test
	public void test_moveRight() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.moveRight();
		assertEquals("x move 10 unit to the right", 310, s.getX_coordinate());
	}
	@Test
	public void test_moveRight_OutOfRange() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setX_coordinate(0);
		s.moveLeft();
		assertEquals("x should not change since the Avatar can not move left ", 0, s.getX_coordinate());
	}
	@Test
	public void test_moveUp() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.moveUp();
		assertEquals("x move 10 unit to the up", 290, s.getY_coordinate());

	}
	@Test
	public void test_moveUp_OutOfRange() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setY_coordinate(0);
		s.moveUp();
		assertEquals("y should not change since Avatar can't move any higher", 0, s.getY_coordinate());
	}
	@Test
	public void test_moveDown() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.moveDown();
		assertEquals("x move 10 unit to the down", 310, s.getY_coordinate());
	}
	@Test
	public void test_moveDown_OutOfRange() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setY_coordinate(900);
		s.moveDown();
		assertEquals("y should not change since Avatar is not in window", 900, s.getY_coordinate());
	}
	@Test
	public void test_delete() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setX_coordinate(50);
		s.setY_coordinate(50);
		s.delete();
		assertEquals("x coordinate is set to -1000", -1000, s.getX_coordinate());
		assertEquals("y coordinate is set to -1000", -1000, s.getY_coordinate());
	}
	@Test
	public void test_delete_Elsewhere() {
		Avatar_Logic s = new Avatar_Logic(300, 300);
		s.setX_coordinate(50);
		s.setY_coordinate(50);
		s.delete();
		assertTrue("x coordinate should be -1000", s.getX_coordinate() == -1000);
		assertTrue("y coordinate should be -1000", s.getY_coordinate() == -1000);
		assertFalse("x coordinate should be -1000", s.getX_coordinate() != -1000);
		assertFalse("y coordinate should be -1000", s.getY_coordinate() != -1000);
	}

}