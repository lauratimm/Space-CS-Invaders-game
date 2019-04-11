package Logic;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class Heart_LogicTest {
	@Test
	public void test_setgetLife() {
		Heart_Logic s = new Heart_Logic();
		s.setLife(5);
		assertEquals("Number of Heart_Logics made is 5", 5, s.getLife());
	}
	@Test
	public void test_loseLife() {
		Heart_Logic s = new Heart_Logic();
		s.loseLife();
		assertEquals("Lose 1 Heart_Logic", 4, s.getLife());
	}
	@Test
	public void test_removeHeart_LogicList() {
		Heart_Logic s = new Heart_Logic();
		s.setLife(3);
		s.createHeartList(10);
		s.removeHeartList();
		assertEquals("list is empty", 0, s.getHeartList().size());
		
	}
	@Test
	public void test_createHeart_LogicList() {
		Heart_Logic s = new Heart_Logic();
		s.setLife(5);
		s.createHeartList(10);
		assertEquals("List has 5 hearts", 5, s.getHeartList().size());			
	}
}