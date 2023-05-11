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
        Rectangle r1 = new Rectangle(new Vector2d(0,0), new Vector2d(1,4), Rectangle.RectangleSet.FIRST_SET);
        Rectangle r2 = new Rectangle(new Vector2d(1,0), new Vector2d(1,-1), Rectangle.RectangleSet.FIRST_SET);

        assert r1.checkcross(r2);
    }
    /**
     * Второй тест
     */
    @Test
    public void test2() {
        Rectangle r1 = new Rectangle(new Vector2d(-1,-1), new Vector2d(2,1), Rectangle.RectangleSet.FIRST_SET);
        Rectangle r2 = new Rectangle(new Vector2d(-1,-1), new Vector2d(2,1), Rectangle.RectangleSet.FIRST_SET);

        assert r1.checkcross(r2);
    }
    /**
     * Третий тест
     */
    @Test
    public void test3() {
        Rectangle r1 = new Rectangle(new Vector2d(-1,-1), new Vector2d(2,1), Rectangle.RectangleSet.FIRST_SET);
        Rectangle r2 = new Rectangle(new Vector2d(-1,1), new Vector2d(2,-1), Rectangle.RectangleSet.FIRST_SET);

        assert r1.checkcross(r2);
    }
    /**
     * Четвертый тест
     */
    @Test
    public void test4() {
        Rectangle r1 = new Rectangle(new Vector2d(-5,-4), new Vector2d(1,5), Rectangle.RectangleSet.FIRST_SET);
        Rectangle r2 = new Rectangle(new Vector2d(7,5), new Vector2d(7,5), Rectangle.RectangleSet.FIRST_SET);

        assert !r1.checkcross(r2);
        assert !r2.checkcross(r1);
    }
    /**
     * Пятый тест
     */
    @Test
    public void test5() {
        Rectangle r1 = new Rectangle(new Vector2d(0,0), new Vector2d(0,0), Rectangle.RectangleSet.FIRST_SET);
        Rectangle r2 = new Rectangle(new Vector2d(0,0), new Vector2d(0,0), Rectangle.RectangleSet.FIRST_SET);

        assert r1.checkcross(r2);
    }

    /**
     * Шестой тест
     */
    @Test
    public void test6() {
        Rectangle r1 = new Rectangle(new Vector2d(-7,-7), new Vector2d(7,7), Rectangle.RectangleSet.FIRST_SET);
        Rectangle r2 = new Rectangle(new Vector2d(-5,-5), new Vector2d(5,5), Rectangle.RectangleSet.FIRST_SET);

        assert r1.checkcross(r2);
        assert r2.checkcross(r1);
    }
}
