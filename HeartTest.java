import static org.junit.Assert.*;
import javafx.scene.image.*;
import org.junit.Test;
import java.util.ArrayList;
public class HeartTest{

	@Test
	public void testHeart() {
		Image img = new Image("heart.png");
		Avatar c = new Avatar(10, 10, 10, 10, "avatar", img);
		ArrayList<Character> num_h = new ArrayList<Character>(5);
		Heart heart = new Heart();
		heart.numHeart(num_h, c, img);
		int num = c.getLife();
		assertEquals("blah", num, num_h.size());
		
	}
}
