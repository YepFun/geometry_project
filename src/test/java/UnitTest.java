import app.Point;
import app.Rectangle;
import app.Task;
import misc.CoordinateSystem2d;
import misc.Vector2d;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс тестирования
 */
public class UnitTest {

    /**
     * Первый тест
     */
    @Test
    public void test1() {
        Rectangle r1 = new Rectangle(new Vector2d(0,0), new Vector2d(1,4));
        Rectangle r2 = new Rectangle(new Vector2d(1,0), new Vector2d(1,-1));

        assert r1.checkcross(r2);
    }
    /**
     * Первый тест
     */
    @Test
    public void tes1() {
        Rectangle r1 = new Rectangle(new Vector2d(0,0), new Vector2d(1,4));
        Rectangle r2 = new Rectangle(new Vector2d(1,0), new Vector2d(1,-1));

        assert !r1.checkcross(r2);
    }


}
