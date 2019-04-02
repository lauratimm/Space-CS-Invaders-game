

import static org.junit.Assert.*;

import org.junit.Test;

public class AvatarTest {

	@Test
	public void test_getX_Coordinate() {
		Avatar s = new Avatar(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate());
	}
	@Test
	public void test_getY_Coordinate() {
		Avatar s = new Avatar(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}
	@Test
	public void test_moveLeft() {
		Avatar s = new Avatar(300, 300);
		s.moveLeft();
		assertEquals("x move 1 unit to the left", 299, s.getX_coordinate());
	}

}
